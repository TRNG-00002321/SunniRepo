# Assignment 3
# 1. Write some data or dictionary into a file. Take input from user. Append each time.
# 2. Read data from file and allow for searching data.
import json
import sys


def read_json():
    try:
        with open("data.json", "r") as file:
            return json.load(file)
    except FileNotFoundError:
        return []

def write_json(data):
    with open("data.json", "w") as file:
        json.dump(data, file, indent=4)

def get_new_entry():
    name = input("Enter your name: ")
    age = input("Enter your age: ")
    city = input("Enter your city: ")
    return {"name":name, "age":age, "city":city}

def add_new_entry():
    print("Adding New Entry")
    people = read_json()
    people.append(get_new_entry())
    write_json(people)

def filter_by_name(people):
    name = input("Enter your name: ")
    return list(filter(lambda x: x["name"] == name, people))

def filter_by_age(people):
    age = input("Enter your age: ")
    return list(filter(lambda x: x["age"] == age, people))

def filter_by_city(people):
    city = input("Enter your city: ")
    return list(filter(lambda x: x["city"] == city, people))

def search_entry():
    print("Searching For Entry")

    people = filter_by_name(read_json())
    if len(people) > 1:
        print("Multiple entries found")
        people = filter_by_age(people)

    if len(people) > 1:
        print("Multiple entries found")
        people = filter_by_city(people)

    if len(people) == 1:
        print("Found!")
        print(people[0])
    else:
        print("Not found")

def main():
    print("1. Add new entry")
    print("2. Search for entry")
    try:
        selection = int(input("Choose an option: "))
    except ValueError:
        print("Invalid entry")
        sys.exit()
    if selection == 1:
        add_new_entry()
    elif selection == 2:
        search_entry()

main()

