""" @Authors
* Student Names: İhsan Gök, Ozan ölmez, Atahan Çolak
* Student IDs: 150210093, 150220045, 150210106
"""
from __future__ import annotations


""" Compile and run generated Java task tests.
    This script looks for, each representing a task.
    For each task, it attempts to compile "Solution.java" and "Main.java", then runs "Main" to execute the tests.
    It reports pass/fail status
"""


import argparse
import shutil
import subprocess
import sys
from pathlib import Path


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser(
        description="Compile Solution.java and Main.java for generated Java tasks."
    )
    parser.add_argument(
        "--root",
        type=Path,
        default=Path("gpt-5.4/Java"),
        help="Root directory containing per-task Java folders.",
    )
    parser.add_argument(
        "--task",
        action="append",
        default=[],
        help="Specific task id(s) to run, for example 0 or 162. Can be passed multiple times.",
    )
    parser.add_argument(
        "--stop-on-failure",
        action="store_true",
        help="Stop after the first compile or test failure.",
    )
    parser.add_argument(
        "--clean",
        action="store_true",
        help="Delete generated .class files after each task run.",
    )
    return parser.parse_args()


def find_tasks(root: Path, selected_tasks: list[str]) -> list[Path]:
    if selected_tasks:
        tasks = [root / task for task in selected_tasks]
    else:
        tasks = [path for path in root.iterdir() if path.is_dir()]

    return sorted(tasks, key=lambda path: path.name)


def run_command(command: list[str], cwd: Path) -> subprocess.CompletedProcess[str]:
    return subprocess.run(
        command,
        cwd=cwd,
        text=True,
        capture_output=True,
        check=False,
    )


def cleanup_classes(task_dir: Path) -> None:
    for class_file in task_dir.glob("*.class"):
        class_file.unlink(missing_ok=True)


def print_block(title: str, content: str) -> None:
    if content.strip():
        print(f"  {title}:")
        print(content.rstrip())


def run_task(task_dir: Path, clean: bool) -> tuple[bool, str]:
    solution_file = task_dir / "Solution.java"
    main_file = task_dir / "Main.java"

    if not solution_file.exists() or not main_file.exists():
        return False, "Missing Solution.java or Main.java"

    compile_result = run_command(["javac", "Solution.java", "Main.java"], task_dir)
    if compile_result.returncode != 0:
        details = []
        if compile_result.stdout.strip():
            details.append(f"stdout:\n{compile_result.stdout.rstrip()}")
        if compile_result.stderr.strip():
            details.append(f"stderr:\n{compile_result.stderr.rstrip()}")
        if clean:
            cleanup_classes(task_dir)
        return False, "\n".join(details) if details else "Compilation failed"

    run_result = run_command(["java", "Main"], task_dir)
    if clean:
        cleanup_classes(task_dir)

    if run_result.returncode != 0:
        details = []
        if run_result.stdout.strip():
            details.append(f"stdout:\n{run_result.stdout.rstrip()}")
        if run_result.stderr.strip():
            details.append(f"stderr:\n{run_result.stderr.rstrip()}")
        return False, "\n".join(details) if details else "Execution failed"

    output_parts = []
    if run_result.stdout.strip():
        output_parts.append(f"stdout:\n{run_result.stdout.rstrip()}")
    if run_result.stderr.strip():
        output_parts.append(f"stderr:\n{run_result.stderr.rstrip()}")
    return True, "\n".join(output_parts)


def main() -> int:
    args = parse_args()

    if shutil.which("javac") is None or shutil.which("java") is None:
        print("Missing Java runtime tools: both 'javac' and 'java' must be available.", file=sys.stderr)
        return 2

    if not args.root.exists():
        print(f"Root directory not found: {args.root}", file=sys.stderr)
        return 2

    tasks = find_tasks(args.root, args.task)
    if not tasks:
        print("No task directories found.", file=sys.stderr)
        return 2

    passed = 0
    failed = 0

    for task_dir in tasks:
        ok, details = run_task(task_dir, args.clean)
        status = "PASS" if ok else "FAIL"
        print(f"[{status}] {task_dir.name}")
        print_block("Details", details)

        if ok:
            passed += 1
        else:
            failed += 1
            if args.stop_on_failure:
                break

    print(f"\nSummary: {passed} passed, {failed} failed")
    return 0 if failed == 0 else 1


if __name__ == "__main__":
    raise SystemExit(main())
