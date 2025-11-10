import json
import os


def create_file(filename):
    with open(filename, 'w') as file:
        if file:
            return True
    return False

def read_file(filename):
    if not os.path.isfile(filename):
        return {}
    with open(filename, 'r') as file:
        return json.loads(file.read())

def write_file(filename, data):
    with open(filename, 'w') as file:
        json.dump(data, file)
        return True
