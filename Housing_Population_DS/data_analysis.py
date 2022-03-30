"""""
Deangelo Bowen SDEV300 Feb 13th 2022
This project was created in cooperation with UMGC SDEV 300
Week 5 guidelines. It's purpose is intended online for learning and
training purposes.
"""""
import sys

import matplotlib.pyplot as plt
import numpy as np
import pandas as pd

HOUSING = "Housing.csv"
POP_CHANGE = "PopChange.csv"


def menu():
    """
    Menu Operators designed for user input. Depending on the user input
    one of two .csv files will be loaded.
    :rtype: object
    """
    menu_items = {
        'A.': "Population Data",
        'B.': "Housing Data",
        'C.': "Exit"
    }
    while True:
        menu_items.items()  # Print selection menu

        selection = input("\nPlease make a selection from the menu above:\t").lower()

        if selection == 'a':
            read_csv(POP_CHANGE)
        elif selection == 'b':
            read_csv(HOUSING)
        elif selection == 'c':
            print("\nProgram will now exit")
            sys.exit()  # Exit program
        else:
            print("\nError! Invalid selection. Please try again.\n")
            menu()  # Return to main menu


def read_csv(file):
    """
    Reads in file
    """
    data_frame = pd.read_csv(file)  # Read in csv file

    if file == POP_CHANGE:
        PopChange(data_frame)
    else:
        Housing(data_frame)


def generate_histogram(data, title):
    """
    Generates a histogram based on user selection
    """
    mean = data.mean()  # Mean of data
    stdev = data.std()  # Standard Deviation of data
    calculation = mean + stdev * np.random.randn(10000)

    plt.hist(calculation, bins='auto')
    plt.grid(True)

    plt.title(title)

    plt.savefig(f"{title}{'.svg'}")

    plt.show()


class PopChange:
    """""
    Population change class data function
    """""
    def __init__(self, data_frame):
        self.data_frame = data_frame

        self.display_menu()  # Display selection menu

    def display_menu(self):
        """
        Menu within csv for direct function selection
        based on user input and data in file.
        """
        menu_items = {
            'A.': "Pop Apr 1",
            'B.': "Pop Jul 1",
            'C.': "Change Pop",
            'D.': "Main Menu"
        }

        for item in menu_items:
            print(item, "\t", menu_items[item])  # Print selection menu

        while True:
            selection = input("\nSelect which data you would like to view :\t").lower()
            if selection == 'a':
                self.population_data(self.data_frame[menu_items['A.']])
            elif selection == 'b':
                self.population_data(self.data_frame[menu_items['B.']])
            elif selection == 'c':
                self.population_data(self.data_frame[menu_items['C.']])
            elif selection == 'd':
                menu()  # Return to main menu
            else:
                print("\nError, your selection was invalid. Please try again.\n")
                self.display_menu()  # Return to selection menu

    def population_data(self, data):
        """
        Analyzes data contained within the csv files,
        I/O operated on said data, and a histogram can be printed
        on user discretion.
        """
        pop_info = {
            "\tCount:": data.count(),
            "\tMean:": data.mean(),
            "\tStd Deviation:": data.std(),
            "\tMin:": data.min(),
            "\tMax:": data.max()
        }

        print("\n", "-" * 30)

        for item in pop_info:
            print(item, f"{pop_info[item]:10.2F}")  # Print data analysis dictionary

        print("-" * 30, "\n")

        while True:
            hist_choice = input("\nWould you like to generate a histogram? Y / N\t").lower()
            if hist_choice == "y":
                generate_histogram(data, "Histogram Data Display")
                print("\nHistogram has been printed, please review.\n")
            elif hist_choice == "n":
                print("No histogram will be printed")
            else:
                print("\nSorry, please try again.\n")
            break
        print("\n")
        self.display_menu()


class Housing:
    """""
    Housing class set for data retrieval
    """""
    def __init__(self, data_frame):
        self.data_frame = data_frame

        self.display_menu()  # Display selection menu

    def display_menu(self):
        """
        Displays a selection menu inside the housing menu that allows the
        user to select specifications located in the .csv
        """
        menu_items = {
            'A.': "Age of House",
            'B.': "Number of Bedrooms",
            'C.': "Year Built",
            'D.': "Number of Rooms",
            'E.': "Utility",
            'F.': "Return to Menu",
        }

        for item in menu_items:
            print(item, "\t", menu_items[item])  # Print selection menu

        while True:
            selection = input("\nSelect a column you wish to analyze:\t").lower()  # Get user input

            if selection == 'a':
                self.housing_data(self.data_frame["AGE"])
            elif selection == 'b':
                self.housing_data(self.data_frame["BEDRMS"])
            elif selection == 'c':
                self.housing_data(self.data_frame["BUILT"])
            elif selection == 'd':
                self.housing_data(self.data_frame["ROOMS"])
            elif selection == 'e':
                self.housing_data(self.data_frame["UTILITY"])
            elif selection == 'f':
                menu()
            else:
                print("\nError! Invalid Selection. Please try again.\n")
                self.display_menu()

    def housing_data(self, data):
        """""
        Calculations for housing data
        """""
        housing_menu = {
            "\tCount:": data.count(),
            "\tMean:": data.mean(),
            "\tStd Deviation:": data.std(),
            "\tMin:": data.min(),
            "\tMax:": data.max()
        }

        print("\n", "-" * 30)

        for item in housing_menu:
            print(item, f"{housing_menu[item]:10.2F}")  # Print data analysis dictionary

        print("-" * 30, "\n")

        while True:
            hist_choice = input("\nWould you like to generate a histogram? Y / N\t").lower()
            if hist_choice == "y":
                generate_histogram(data, "Histogram Data Display")
                print("\nHistogram has been printed, please review.\n")
            elif hist_choice == "n":
                print("No histogram will be printed")
            else:
                print("\nSorry, please try again.\n")
            break
        print("\n")
        self.display_menu()


if __name__ == "__main__":
    print("Welcome to the my Data Analysis app!\n")
    menu()
