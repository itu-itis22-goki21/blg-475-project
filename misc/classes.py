""" @Authors
* Student Names: Ozan Ölmez
* Student IDs: 150220045
"""

"""
    modification to prompts.py I used to create ECs
    and see which base tests cover which ones
"""

import json

INPUT_FILE = "data\out3.jsonl" # final 30

with open(INPUT_FILE, "r") as f:
    for line in f:
        # print task id, prompt, base tests
        data = json.loads(line.strip())
        print("task_id:", data["task_id"])
        print(data["prompt"])
        print(data["test"])

        _ = input("") # wait before showing next task

        print("-" * 50)