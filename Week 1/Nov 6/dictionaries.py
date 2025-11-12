# Problem 1:
# Create a dictionary of five countries and their capitals.
# Write a function that takes a country name as input and
# returns its capital.
capitals = {"China": "Beijing",
            "Egypt": "Cairo",
            "France": "Paris",
            "Germany": "Berlin",
            "India": "New Delhi",
            "Japan": "Tokyo"}

def get_capital():
    country = input("Enter country name: ")
    if country in capitals:
        return capitals[country]
    else:
        return "Capital not found"
# print(get_capital())


# Problem 2: Make a dictionary of student
# names and their scores. Write a function
# to find the student with the highest score.
from functools import reduce
students = {"Alice": 95,
            "Bob": 90,
            "Charlie": 75,
            "David": 82,
            "Eve": 100,}
def get_highest_score():
    return reduce(lambda x, y: x if x > y else y, students.values())
print(get_highest_score())

# Problem 3. Create a nested dictionary of three employees,
# each with keys for name, age, and salary. Write a function
# to give each employee a 10% raise and print the updated dictionary.
employees = {"emp01" : {"name": "Alice", "age":25, "salary": 50000},
             "emp02" : {"name": "Bob", "age":34, "salary": 45000},
             "emp03" : {"name": "Charlie", "age":45, "salary": 100000},}
def apply_raise(percent):
    # print(list(map(lambda x: x["salary"] * (1+percent), employees.values())))
    for key, value in employees.items():
        value["salary"] = value["salary"] * (1 + percent)
    return employees
print(apply_raise(.10))

# Problem 4. Write a Python program to add a key to a dictionary
def add_key(person, key, value):
    person[key] = value
    return person
my_person = {"Name": "Alice", "Age": 25,}
print(my_person)
my_person = add_key(my_person, "City", "New York")
print(my_person)

# 5. Write a Python program to concatenate following dictionaries to create a new one.
dict1 = {"Name" : "Ram" , "Age" : 23}
dict2 = {"City" : "Salem", "Gender" : "Male"}
def concat_dict(d1, d2):
    for key, value in d1.items():
        d2[key] = value
    return d2
print(concat_dict(dict1, dict2))

# 6. Write a Python program to check whether a given key already exists in a dictionary.
# Sample Output
# {'Name' : 'Ram', 'Age' : 23,}
# Key = Name
# Key is Available in the Dictionary
person = {"Name": "Alice", "Age": 25, "City": "New York"}
def contains(key):
    return key in person
print(contains("Salary"))

# 75. Write a Python program to iterate over dictionaries using for loops.
# Sample Output
# {"Name" : "Ram" , "Age" : 23 , "City" : "Salem", "Gender" : "Male"}
# Name : Ram
# Age : 23
# City : Salem
# Gender : Male
def print_dict(d):
    for key, value in d.items():
        print(f"{key}: {value}")
print_dict(person)



