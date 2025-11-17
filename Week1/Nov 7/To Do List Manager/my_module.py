import json
def read_json_from_file(filename):
    with open(filename, "r") as f:
        file_contents = None
        try:
            file_contents = json.load(f)
        except json.decoder.JSONDecodeError:
            print("")
        return file_contents

def write_json_to_file(filename, todo_list):
    with open(filename, "w") as f:
        json.dump(todo_list, f, indent=4)