import sys

drinks = {"water": 1.0, "cola":1.50, "gatorade": 2.0}
drinks = list(enumerate(drinks.items()))

def display_menu():
    print("Choose from the following drinks:")
    for i, (drink, price) in drinks:
        print("{}: {} - ${:.2f}".format(i+1, drink, price))

def get_selection():
    selection = -1
    try:
        selection = int(input("Please enter drink number: "))
    except ValueError:
        print("Invalid selection. Please try again.")
        sys.exit()
    if selection < 0 or selection > len(drinks):
        print("Invalid selection. Please try again.")
        sys.exit()
    return selection - 1

def get_money(selection):
    _, (drink, price) = drinks[selection]
    print("The price of {} is ${:.2f}".format(drink, price))
    quarters = 0
    nickels = 0
    dimes = 0
    pennies = 0
    try:
        quarters = int(input("Please enter how many quarters: ")) * 0.25
        nickels = int(input("Please enter how many nickels: ")) * 0.05
        dimes = int(input("Please enter how many dimes: ")) * 0.10
        pennies = int(input("Please enter how many pennies: ")) * 0.01
    except ValueError:
        print("Invalid entry. Please try again.")
        sys.exit()
    return quarters +  nickels +  dimes +  pennies

def get_change(selection, total):
    _, (_, price) = drinks[selection]
    return total - price

def dispense_drink(selection, change):
    _, (drink, _) = drinks[selection]
    print("Here is your change: ${:.2f}".format(change))
    print("Here is your drink: {}".format(drink))

def main():
    display_menu()
    selection = get_selection()
    total = get_money(selection)
    change = get_change(selection, total)
    print("Your total amount entered is: ${:.2f}".format(total))
    if change > 0:
        dispense_drink(selection, change)
    else:
        print("You have insufficient funds for this selection.")
        print("Please try again.")



if __name__ == "__main__":
    main()