import json
import os
import sys

import my_module

def display_todo_list(todo_list):
    if not todo_list:
        print("No Todos")
        return
    print("# - Task: Status")
    for i, (task, status) in enumerate(todo_list.items()):
        print(f"{i} - {task}: {status}")
    print()

def mark_as_complete(todo_list):
    display_todo_list(todo_list)
    index = int(input("Enter task to complete: "))
    todo_list[list(todo_list.keys())[index]] = "Completed"
    return todo_list


def add_task(todo_list):
    print("Enter Task ")
    task = input("> ")
    todo_list[task] = "Incomplete"
    return todo_list

def delete_task(todo_list):
    print(todo_list)
    return {task : status for task, status in todo_list.items() if status == "Incomplete"}
def write_todo(todo_list):
    my_module.write_json_to_file('todo.json', todo_list)
    sys.exit()


menu_options = {"Mark Task As Complete": mark_as_complete,
                "Add Task": add_task,
                "Delete Completed Tasks": delete_task,
                "Exit": write_todo}

def create_file(filename):
    open(filename, "w").close()


def main():
    filename = "todo.json"
    if not os.path.exists(filename):
        open(filename, "w").close()

    todo_list = my_module.read_json_from_file(filename)
    if todo_list is None:
        todo_list = {}
    while True:
        display_todo_list(todo_list)

        print("Select a number from these options:")
        for i, option in enumerate(menu_options.keys()):
            print(f"{i}: {option}")
        menu_index = 3
        try:
            menu_index = int(input("> "))
        except ValueError:
            print("Please enter a number")
        else:
            if menu_index < 0 or menu_index >= len(menu_options):
                print("Please enter a valid option")
            else:
                todo_list = menu_options[list(menu_options.keys())[menu_index]](todo_list)
        print()


main()
