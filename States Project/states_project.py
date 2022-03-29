''''
Author: DeAngelo Bowen
@param : display user selected state,
population, and state flower
'''
from logging import exception
import sys
from PIL import Image  # Image Database
import pandas as pd  # Pandas Database over CSV
import matplotlib.pyplot as plt  # Plotting Database

menu = {'A.': "Show info of all states", 'B.': "Search by State Name",
        'C.': "Show bar graph",
        'D.': "Update the overall state population for a specific state.",
        'E.': "Exit"}
while True:
    data = pd.read_csv('statedata.csv')  # read CSV ini
    options = menu.keys()
    for entry in options:
        print(entry, menu[entry])
    print(" ")
    selection = input("Please select a choice from above: ").lower()
    print(" ")
    if selection == 'a':
        print(data)
        print(" ")
    elif selection == 'b':
        while True:
            try:
                n = input("Please input the name of the state you would like to view: ").capitalize()
                choice = data[data['state'].str.match(n)]
                print(choice)
                print(" ")
                im = Image.open(n + ".jpeg")
                im.show()
                print(" ")
            except exception:
                print(n, "is not a state, please try again!") 
                print(" ")
    elif selection == 'c':
        df = data.sort_values(by='Pop2020', ascending=False)[:5]
        unit_colors = ['green', 'blue', 'red', 'orange', 'violet']
        plt.bar(df['state'], df['Pop2020'], color=unit_colors)
        plt.title('Top 5 States by Population', fontsize=14)
        plt.xlabel('State', fontsize=14)
        plt.ylabel('Population', fontsize=14)
        plt.show()
    elif selection == 'd':
        df = pd.read_csv("statedata.csv")
        print(data)
        print("")
        print("Use the number indicator on the far left to select a state.")
        a = int(input("Which numeric state would you like to update: "))
        b = input("Enter new population number: ")
        print(" ")
        df._set_value(a, 'Pop2020', b)
        df.to_csv("statedata.csv", index=False)
        print("Updated State Population information: ")
        print(df.loc[[a], :])
        print(" ")
    elif selection == 'e':
        print("Program now closing.")
        sys.exit()
    else:
        print("That is not an operable choice, please try again.")
