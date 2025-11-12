# Create a string list containing 5 elements. Based on this list, create another list having elements from the 
# previous list containing the charater "a"

fruits = ["apple", "kiwi", "banana", "lemon", "mango"]
new_fruits = []
for fruit in fruits:
    if "a" in fruit:
        new_fruits.append(fruit)
print(new_fruits)

new_fruits = [x for x in fruits if "a" in x]
print(new_fruits)
