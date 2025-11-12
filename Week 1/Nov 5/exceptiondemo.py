# Write a program to input two numbers. Calculate and display their division
def divide(a, b):
    try:
        val = a // b
    except:
        print("Cannot divide by zero")
    else:
        return val
    # return a // b

try: 
    x = int(input("Enter value: "))
    y = int(input("Enter value: "))
except:
    print("Invalid Input Value")
else:
    print(divide(x, y))
