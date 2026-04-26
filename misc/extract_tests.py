"""Extract dataset-backed Java tests into the Maven test tree."""

from __future__ import annotations

import argparse
import json
import re
import textwrap
from pathlib import Path

REPO_ROOT = Path(__file__).resolve().parent.parent


def extract_import_block(declaration: str) -> str:
    import_lines = []

    for line in declaration.splitlines():
        stripped = line.strip()
        if stripped.startswith("import "):
            import_lines.append(stripped)

    if not import_lines:
        return ""

    return "\n".join(import_lines) + "\n\n"


def resolve_repo_path(path: Path) -> Path:
    if path.is_absolute():
        return path
    return (REPO_ROOT / path).resolve()


def sanitize_java_identifier(name: str) -> str:
    sanitized = re.sub(r"[^0-9A-Za-z_$]", "", name)
    if not sanitized:
        return "GeneratedMutationTest"
    if sanitized[0].isdigit():
        sanitized = f"Generated{sanitized}"
    return sanitized


def extract_main_body(test_code: str) -> str:
    main_signature = "public static void main(String[] args)"
    signature_index = test_code.find(main_signature)
    if signature_index == -1:
        raise ValueError("Could not find main method in test block.")

    body_start = test_code.find("{", signature_index)
    if body_start == -1:
        raise ValueError("Could not find opening brace for main method.")

    brace_depth = 1
    position = body_start + 1
    while position < len(test_code):
        char = test_code[position]
        if char == "{":
            brace_depth += 1
        elif char == "}":
            brace_depth -= 1
            if brace_depth == 0:
                body = test_code[body_start + 1:position]
                return textwrap.dedent(body).strip("\n")
        position += 1

    raise ValueError("Could not find closing brace for main method.")


def build_junit_test(
    package_name: str,
    import_block: str,
    class_name: str,
    test_body: str,
) -> str:
    parts = [f"package {package_name};", "", "import org.junit.jupiter.api.Test;"]

    if import_block:
        parts.append("")
        parts.extend(import_block.rstrip().splitlines())

    indented_body = textwrap.indent(test_body, " " * 8)
    parts.extend(
        [
            "",
            f"class {class_name} {{",
            "",
            "    @Test",
            "    void runsDatasetMutationChecks() {",
            indented_body,
            "    }",
            "}",
            "",
        ]
    )
    return "\n".join(parts)


def extract_tests(
    input_file: Path,
    output_root: Path,
    model: str,
    filename: str,
    language: str,
) -> int:
    input_file = resolve_repo_path(input_file)
    output_root = resolve_repo_path(output_root)
    class_name = sanitize_java_identifier(Path(filename).stem)
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
            task_dir = output_root / model / f"task{task_number}"
            task_dir.mkdir(parents=True, exist_ok=True)

            output_path = task_dir / filename
            import_block = extract_import_block(declaration) if language == "Java" else ""
            package_name = f"{model}.task{task_number}"
            test_body = extract_main_body(test_code)
            junit_test = build_junit_test(package_name, import_block, class_name, test_body)
            output_path.write_text(junit_test, encoding="utf-8")
            written += 1

    return written


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser(
        description="Extract JSONL tests into separate JUnit files under src/test/java."
    )
    parser.add_argument(
        "input_positional",
        nargs="?",
        type=Path,
        help="Optional positional input path for compatibility.",
    )
    parser.add_argument(
        "output_positional",
        nargs="?",
        type=Path,
        help="Optional positional output root for compatibility.",
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
        default=Path("src/test/java"),
        help="Root test directory that contains model/task folders.",
    )
    parser.add_argument(
        "--filename",
        default="MutationDatasetTest.java",
        help="Name of the generated JUnit test file.",
    )
    parser.add_argument(
        "--model",
        default="gpt54",
        help="Model namespace under src/test/java, for example gpt54 or sonnet46.",
    )
    parser.add_argument(
        "--language",
        default="Java",
        help="Task language prefix to filter by, for example Java.",
    )
    return parser.parse_args()


def main() -> None:
    args = parse_args()
    input_file = args.input_positional or args.input
    output_root = args.output_positional or args.output_root
    written = extract_tests(
        input_file=input_file,
        output_root=output_root,
        model=args.model,
        filename=args.filename,
        language=args.language,
    )
    resolved_output_root = resolve_repo_path(output_root) / args.model
    print(f"Wrote {written} test files to {resolved_output_root}")


if __name__ == "__main__":
    main()
