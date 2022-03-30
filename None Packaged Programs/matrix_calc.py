"""'Program designed to operated based on UMGC'S SDEV 300 Week 4 Lab Assignment"""""
# DeAngelo Bowen
# SDEV 300, Week 4
# Feb 6th 2022


import re
import sys
import numpy as np


while True:
    print("Do you want to play the Matrix Game?")
    selection = input("Y for yes, N for No: ").upper()
    if selection == "N":
        print("Program will now exit. Thank you for playing")
        sys.exit()
    elif selection == 'Y':
        while True:
            tele_num = input("Enter your phone number as such (XXX-XXX-XXXX): ")
            if not re.match('\\d{3}-\\d{3}-\\d{4}', tele_num):
                print("This is not the correct number format. Please try again.")
            else:
                break
        while True:
            zipcode = input("Please enter your 5 digit zipcode (XXXXX-XXXX): ")
            if not re.match("\\d{5}-\\d{4}", zipcode):
                print("That is not a proper zipcode. Please try again: ")
            else:
                break
        while True:
            choice = input("Would you like to continue, Y/N: ").upper()
            if choice == 'N':
                print("Program will now close. Thank you for playing.")
                sys.exit()
            elif choice == 'Y':
                print("Please enter your 1st 3x3 matrix in 3x3 form seperated by a space: ")
                x = []
                for i in range(3):
                    row = input().split()
                    row = list(map(int, row))
                    x.append(row)
                print("Your 1st Matrix is:")
                print('\n'.join([''.join([f"{item:3}" for item in row])
                                 for row in x]))
                print("Please enter your 2nd 3x3 matrix in 3x3 form form seperated by a space: ")
                y = []
                for i in range(3):
                    row = input().split()
                    row = list(map(int, row))
                    y.append(row)
                print("Your 2nd Matrix is:")
                print('\n'.join([''.join([f"{item:3}" for item in row])
                                 for row in y]))
                menu = {'A': "Add My Matrix",
                        'B': "Subtract My Matrix",
                        'C': "Multiply My Matrix",
                        'D': "Element by element multiplication"}
                for n in menu.items():
                    print(n, menu[n])
                print(" ")
                math = input("Please select from an option above: ").upper()
                if math == 'A':
                    print("Adding Matrices. Results are: ")
                    x = np.array(x)
                    y = np.array(y)
                    z = np.add(x, y)
                    print('\n'.join([' '.join([f'{item:3}' for item in row])
                                     for row in z]))
                    print("Transpose is: ")
                    t = np.transpose(z)
                    print('\n'.join([' '.join([f'{item:3}' for item in row])
                                     for row in t]))
                    print("The row and colum mean values are: ")
                    print("Row: ", np.mean(z, axis=1))
                    print("Column: ", np.mean(z, axis=0))
                if math == 'B':
                    print("Subtracting Matrices. Results are: ")
                    x = np.array(x)
                    y = np.array(y)
                    z = np.subtract(x, y)
                    print('\n'.join([' '.join([f'{item:3}' for item in row])
                                     for row in z]))
                    print("Transpose is: ")
                    t = np.transpose(z)
                    print('\n'.join([' '.join([f'{item:3}' for item in row])
                                     for row in t]))
                    print("The row and colum mean values are: ")
                    print("Row: ", np.mean(z, axis=1))
                    print("Column: ", np.mean(z, axis=0))
                if math == 'C':
                    print("Multiplying Matrices. Results are: ")
                    x = np.array(x)
                    y = np.array(y)
                    z = np.matmul(x, y)
                    print('\n'.join([' '.join([f'{item:3}' for item in row])
                                     for row in z]))
                    print("Transpose is: ")
                    t = np.transpose(z)
                    print('\n'.join([' '.join([f'{item:3}' for item in row])
                                     for row in t]))
                    print("The row and colum mean values are: ")
                    print("Row: ", np.mean(z, axis=1))
                    print("Column: ", np.mean(z, axis=0))
                if math == 'D':
                    print("Performing Element to Element Multiplication. Results are: ")
                    x = np.array(x)
                    y = np.array(y)
                    z = np.matmul(x, y)
                    print('\n'.join([' '.join([f'{item:3}' for item in row])
                                     for row in z]))
                    print("Transpose is: ")
                    t = np.transpose(z)
                    print('\n'.join([' '.join([f'{item:3}' for item in row])
                                     for row in t]))
                    print("The row and colum mean values are: ")
                    print("Row: ", np.mean(z, axis=1))
                    print("Column: ", np.mean(z, axis=0))
            else:
                print("That is not a proper selection, please try again.")
                print(" ")
    else:
        print("That is not a proper selection, please try again.")
        print(" ")
