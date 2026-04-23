""" @Authors
* Student Names: İhsan Gök  
* Student IDs: 150210093
"""

"""
    python script to extract the prompts from the humaneval_java.jsonl file
"""

import json

def extract_prompts(input_file, output_file):
    with open(output_file, "w") as fout:
        with open(input_file, "r") as fin:
            for line in fin:
                line = line.strip()
                if not line:
                    continue
                data = json.loads(line)
                task_id = data.get("task_id")
                prompt = data.get("prompt")
                if prompt is not None:
                    extracted = {
                        "task_id": task_id,
                        "prompt": prompt,
                    }
                    fout.write(json.dumps(extracted, ensure_ascii=False) + "\n")


if __name__ == "__main__":
    INPUT_FILE = "data/out3.jsonl"
    OUTPUT_FILE = "data/prompts_extracted.jsonl"
    extract_prompts(INPUT_FILE, OUTPUT_FILE)
    print(f"Prompts extracted to {OUTPUT_FILE}")