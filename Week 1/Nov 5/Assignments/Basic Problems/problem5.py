x = 20
y = 45
print(x, y)

# Using temp variable
temp = x
x = y
y = temp
print(x, y)

x = 20
y = 45

# Inplace swap
x = x + y
y = x - y
x = x - y
print(x, y)
