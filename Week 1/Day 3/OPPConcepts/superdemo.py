class Animal:
    def __init__(self, name):
        self.name = name

    def speak(self):
        print(f"{self.name} says makes a sound")

class Cat(Animal):
    def __init__(self, name, color):
        super().__init__(name)
        self.color = color
        
    def speak(self):
        print(f"{self.name} says meow")

    def describe(self):
        print(f"{self.name} is {self.color}")

cat = Cat("cat", "blue")
cat.speak()
cat.describe()