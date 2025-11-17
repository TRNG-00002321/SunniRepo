import math
from abc import ABC, abstractmethod

class Shape(ABC):
    @abstractmethod
    def Shape(self):
        pass

    @abstractmethod
    def area(self):
        pass

class Circle(Shape):
    def __init__(self, radius):
        self.radius = radius

    def Shape(self):
        return "Circle"

    def area(self):
        return math.pi * self.radius * self.radius

class Rectangle(Shape):
    def __init__(self, width, height):
        self.width = width
        self.height = height

    def Shape(self):
        return "Rectangle"

    def area(self):
        return self.width * self.height

class Triangle(Shape):
    def __init__(self, base, height):
        self.base = base
        self.height = height

    def Shape(self):
        return "Triangle"

    def area(self):
        return self.base * self.height * 0.5


circle = Circle(int(input("Enter radius: ")))
print(f"{circle.Shape()}\'s Area = {circle.area()}")


rectangle = Rectangle(int(input("Enter width: ")), int(input("Enter height: ")))
print(f"{rectangle.Shape()}\'s Area = {rectangle.area()}")

# TypeError: Can't instantiate abstract class Shape without an implementation for abstract method 'Shape'
# shape = Shape()
# print(shape.Shape())
