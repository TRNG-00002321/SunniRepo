from functools import reduce


def problem1(words):
    return list(filter(lambda x: len(x) > 5, words))

def problem2(students):
    return list(filter(lambda x: x["grade"] > 90, students))

def problem3(words):
    return reduce(lambda x, y: x + " " + y, words)

def problem4(numbers):
    return reduce(lambda x, y: x if x > y else y, numbers)

def problem5(mylist):
    return reduce(lambda x, y: x + y, mylist)

def main():
    print(problem1(["apple", "banana", "cat", "dog", "elephant", "frog"]))

    students = [
        {"name": "Alice", "grade": 85},
        {"name": "Bob", "grade": 92},
        {"name": "Charlie", "grade": 78},
        {"name": "David", "grade": 95}
    ]
    print(problem2(students))
    print(problem3(["Python", "is", "awesome", "!"]))
    print(problem4([10, 3, 25, 7, 18]))
    print(problem5([[1, 2], [3, 4], [5, 6]]))

if __name__ == "__main__":
    main()


