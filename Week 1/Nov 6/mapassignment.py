# F = (C * 9/5) + 32
# Problem 1
def c_to_f(temps):
    return list(map(lambda c: c * (9/5)+32, temps))

def capitalize(names):
    return list(map(lambda name: name[0].upper() + name[1:], names))

def main():
    celsius_temps = [0, 10, 20, 30]
    print(c_to_f(celsius_temps))

    print(capitalize(["alice", "bob", "charlie"]))


if __name__ == '__main__':
    main()