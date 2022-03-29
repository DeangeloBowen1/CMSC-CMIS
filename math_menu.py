"""Creates loop menu that generates specific calculations based on user input"""
#  DeAngelo Bowen SDEV 300 23 Jan 2022
import string
import random
from datetime import date
import math

menu = {'A.': "Generate Secure Password", 'B.': "Calculate and Format a Percentage",
        'C.': "How many days from today until July 4, 2025",
        'D.': "Use the law of cosines to calculate the leg of a triangle",
        'E.': "calculate the volume of a right circular cylinder", 'F.': "exit"}  # menu-set created
while True:
    options = menu.keys()
    for entry in options:  # menu loop created
        print(entry, menu[entry])

    print(" ")
    selection = input("Please select from the previous menu: ").upper()  # input initialized
    print(" ")
    if selection == 'A':
        complexity = {'A': "Only Upper and Lower Case Characters",
                      'B': "Upper and Lower Case Characters with Numbers",
                      'C': "Upper/Lower Case with Numbers and Special Characters"}
        for n in complexity:
            print(n, complexity[n])  # loop made it easier to print items in a list.
        print(" ")
        choice = input("Select the following complexity in the password generator: ").upper()
        if choice == 'A':
            characters = list(string.ascii_letters)  # inis both upper and lower case letters
        elif choice == 'B':
            characters = list(string.ascii_letters + string.digits)  # inis previous + numbers
        elif choice == 'C':
            characters = list(string.ascii_letters + string.digits + "!#@&*")  # added special chars


        def generate_random_password():  # method for generating a random password
            length = int(input("Desired length of password: "))
            print(" ")
            random.shuffle(characters)
            password = []
            i: int
            for i in range(length):
                password.append(random.choice(characters))
            print("".join(password))
            print(" ")


        generate_random_password()

    elif selection == 'B':
        numbers = []  # empty list
        length = int(input("How many numbers would you like to calculate: "))  # allows all amounts
        for i in range(0, length):
            print("Please a number:")
            var = float(input())  # float initialized for decimal numbers
            numbers.append(var)
        percent = sum(numbers) * 100 / 500
        print("The numbers input are: ", numbers)
        print("These numbers yield ", percent, "%")
        print(" ")
    elif selection == 'C':
        day_1 = date(2022, 1, 23)
        day_2 = date(2025, 7, 4)
        days_until = day_2 - day_1
        print(days_until.days, "days until July 4, 2025")
        print(" ")
    elif selection == 'D':
        print("Use the law of cosines to find side 'c")
        a = int(input("Please input a number for variable a: "))
        b = int(input("Please input a number for variable b: "))
        c = int(input("Please input a number for variable ºC: "))

        equation = math.sqrt((a ** 2 + b ** 2) - (2 * (a * b)) * math.cos(c))
        side_c = equation
        print(f"Side c of the square is {side_c:.2f}")
    elif selection == 'E':
        radius: float = float(input("Enter the radius of the cylinder: "))
        height: float = float(input("Enter the height of the cylinder: "))
        volume = math.pi * pow(radius, 2) * height
        print(f"The volume of a right cylinder will be {volume:.2f}")
        print(" ")
    elif selection == 'F':
        print("Program will now Exit.")
        break
    else:
        print("That is not an available selection.")
