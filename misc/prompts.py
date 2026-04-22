""" @Authors
* Student Names: Ozan Ölmez
* Student IDs: 150220045
"""

"""
    small python script I used to manually select tasks
    and assign them difficulties.
    I reran it on the output of previous runs multiple times
    to progressively narrow the dataset down to 30 tasks
"""

import json

INPUT_FILE = "humaneval_java.jsonl" # on next run this will be out1.jsonl
OUTPUT_FILE = "out1.jsonl" # and this will be out2.jsonl

DIFFS = {
    "e": "easy",
    "m": "moderate",
    "h": "hard"
}

with open(INPUT_FILE, "r") as fin, open(OUTPUT_FILE, "w") as fout:
    for line in fin:
        # print task id and prompt
        data = json.loads(line.strip())
        print("task_id:", data["task_id"])
        print(data["prompt"])

        # decide to include or not
        _ = input("\ninclude? (y/n) ").strip().lower()

        if _ == "y":
            # assign difficulty
            while True:
                d = input("difficulty: ").strip().lower()
                if d in DIFFS: # avoid assigning invalid difficult on accident
                    data["difficulty"] = DIFFS[d]
                    break
                print("invalid difficulty")

            fout.write(json.dumps(data) + "\n") # write to output file with difficulty field

        print("-" * 50)