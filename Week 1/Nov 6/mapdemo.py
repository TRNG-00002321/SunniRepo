# Create a list of four or five numbers
# Calculate and print their squares

def compute_squares(values):
    # squares = [x*x for x in values]
    squares = []
    for value in values:
        squares.append(value ** 2)
    return squares

Numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
print("Values: ", Numbers)
# print("Squares: ", compute_squares(Numbers))

squared_numbers = list(map(lambda x: x ** 2, Numbers))
print("Squares: ", squared_numbers)

# Create a list 1-10. From that list create a new list of even numbers
Numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
even_values = list(filter(lambda x: x % 2 == 0, Numbers))
print("Even values: ", even_values)

# Given a list of number 1-10, calculate and display the sum of number the list
from functools import reduce
values = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
my_sum = reduce(lambda x, y: y + x, values)
print("Sum: ", my_sum)

# Define two list, the first containing 3-4 names, the second list containing the age
names = ["Will", "Sunni", "Erin", "Barb"]
ages = [19, 25, 40, 38]
people = list(zip(names, ages))
print("Names: ", names)
print("Ages: ", ages)
print("People: ", people)

unzipped_names, unzipped_ages = list(zip(*people))
print(list(unzipped_names))
print(unzipped_ages)
