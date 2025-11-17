import os
import json

class TodoList:

    def __init__(self):
        filename = 'todolist.json'
        if os.path.isfile(filename):
            with open(filename, 'r') as f:
                self.my_dict = json.load(f)
        else:
            self.my_dict = {}

    def add_task(self, task):
        self.my_dict[task] = False

    def mark_task(self, task):
        self.my_dict[task] = True

    def remove_task(self, task):
        self.my_dict.pop(task)

    def to_dict(self):
        return self.my_dict
    def __str__(self):
        return self.my_dict.__str__()