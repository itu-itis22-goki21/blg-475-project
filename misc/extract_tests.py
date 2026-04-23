"""Extract Java test files from a JSONL dataset into task folders."""

from __future__ import annotations

import argparse
import json
from pathlib import Path


def extract_import_block(declaration: str) -> str:
    import_lines = []

    for line in declaration.splitlines():
        stripped = line.strip()
        if stripped.startswith("import "):
            import_lines.append(stripped)

    if not import_lines:
        return ""

    return "\n".join(import_lines) + "\n\n"


def extract_tests(input_file: Path, output_root: Path, filename: str, language: str) -> int:
    written = 0

    with input_file.open("r", encoding="utf-8") as fin:
        for line_number, line in enumerate(fin, start=1):
            line = line.strip()
            if not line:
                continue

            data = json.loads(line)
            task_id = data.get("task_id", "")
            test_code = data.get("test")
            declaration = data.get("declaration", "")

            if not task_id.startswith(f"{language}/") or not test_code:
                continue

            _, task_number = task_id.split("/", 1)
            task_dir = output_root / task_number
            task_dir.mkdir(parents=True, exist_ok=True)

            output_path = task_dir / filename
            import_block = extract_import_block(declaration) if language == "Java" else ""
            output_path.write_text(import_block + test_code.rstrip() + "\n", encoding="utf-8")
            written += 1

    return written


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser(
        description="Extract test fields from a JSONL file into per-task folders."
    )
    parser.add_argument(
        "--input",
        type=Path,
        default=Path("data/out3.jsonl"),
        help="Path to the source JSONL file.",
    )
    parser.add_argument(
        "--output-root",
        type=Path,
        default=Path("gpt-5.4/Java"),
        help="Directory containing per-task folders.",
    )
    parser.add_argument(
        "--filename",
        default="Main.java",
        help="Name of the file to create inside each task folder.",
    )
    parser.add_argument(
        "--language",
        default="Java",
        help="Task language prefix to filter by, for example Java.",
    )
    return parser.parse_args()


def main() -> None:
    args = parse_args()
    written = extract_tests(args.input, args.output_root, args.filename, args.language)
    print(f"Wrote {written} test files to {args.output_root}")


if __name__ == "__main__":
    main()
