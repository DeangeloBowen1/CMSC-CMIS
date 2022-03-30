"#DeAngelo Bowen SDV300 14 Jan 2022"
import sys

print("Welcome to the Voter Registration Application.")


def v_appli():
    while True:
        cont = input("Do you want to continue with Voter Registration? Y/N: ").lower()
        if cont == 'y':
            fname = input("Please input your first name: ")
            break
        if cont == 'n':
            print("Thank you for coming!")
            sys.exit()
        else:
            print("Please input either Y for Yes or N for No.")

    while True:
        cont = input("Do you want to continue with Voter Registration? Y/N: ").lower()
        if cont == 'y':
            lname = input("Please input your last name: ")
            break
        if cont == 'n':
            print("Thank you for coming!")
            sys.exit()
        else:
            print("Please input either Y for Yes or N for No.")

    while True:
        cont = input("Do you want to continue with Voter Registration? Y/N: ").lower()
        if cont == 'y':
            age = int(input('Please input your age: '))
            if age < 18:
                verif = input("Is this your correct age Y/N: ").lower()
                if verif == 'y':
                    print("You are not allowed to vote.")
                    sys.exit()
                elif verif == 'n':
                    age = int(input("Please re-input your age: "))
                    if age < 18:
                        print("You are not allowed to vote.")
                        sys.exit()
                    elif age >= 120:
                        print("You are not allowed to vote.")
                        sys.exit()
                    else:
                        break
            if age >= 120:
                verif = input("Is this your correct age Y/N: ").lower()
                if verif == 'y':
                    print("You are not allowed to vote.")
                    sys.exit()
                elif verif == 'n':
                    age = int(input("Please re-input your age: "))
                    if age >= 120:
                        print("You are not allowed to vote.")
                        sys.exit()
                    if age < 18:
                        print("You are not allowed to vote.")
                        sys.exit()
                    sys.exit()
        if cont == 'n':
            print("Thank you for coming!")
            sys.exit()
        break

    while True:
        cont = input("Do you want to continue with Voter Registration? Y/N: ").lower()
        if cont == 'y':
            c_check = input("Are you a registered U.S. citizen? Y/N: ").lower()
            if c_check == 'n':
                print("Only U.S. citizens are allowed to vote.")
                print("Please confirm if you are a U.S. citizen")
                c_check2 = input("Are you a U.S. citizen? Y/N: ").lower()
                if c_check2 == 'n':
                    print("Only U.S. citizens are allowed to vote.")
                    sys.exit()
                if c_check2 == 'y':
                    c_check = c_check2
        elif cont == 'n':
            print("Thank you for your time!")
            sys.exit()
        else:
            print("Please input either Y for Yes or N for No.")
        break

    while True:
        cont = input("Do you want to continue with Voter Registration? Y/N: ").lower()
        if cont == 'y':
            state = input("Please input the abbreviation of the state you are registered from: ").upper()
            state_abbrv = {'AL', 'AK', 'AS', 'AZ', 'AR', 'CA', 'CO', 'CT', 'DE', 'DC', 'FM', 'FL', 'GA', 'GU', 'HI',
                    'ID', 'IL', 'IN', 'IA', 'KS', 'KY', 'LA', 'ME', 'MH', 'MD', 'MA', 'MI', 'MN', 'MS', 'MO',
                    'MT', 'NE', 'NV', 'NH', 'NJ', 'NM', 'NY', 'NC', 'ND', 'MP', 'OH', 'OK', 'OR', 'PW', 'PA',
                    'PR', 'RI', 'SC', 'SD', 'TN', 'TX', 'UT', 'VT', 'VI', 'VA', 'WA', 'WV', 'WI', 'WY'}
            if state not in state_abbrv:
                state = input("That is not a State. Please try again: ").upper()
                if state in state_abbrv:
                    state_question = input("Are you sure this is the correct state? Y/N: ").lower()
                    if state_question == 'y':
                        break
                    if state_question == 'n':
                        print("Please re-start the application as too many errors have occured.")
                        sys.exit()
            if state in state_abbrv:
                state_question = input("Are yyou sure this is the correct state? Y/N: ").lower()
                if state_question == 'y':
                    break
                if state_question == 'n':
                    state = input("Please re-enter the correct state: ")
                    if state not in state_abbrv:
                        state = input("That is not a State. Please try again: ")
                        if state not in state_abbrv:
                            print("You've exceeded the number of tries. Program will now terminate.")
                            sys.exit()
        elif cont == 'n':
            print("Thank you for coming!")
            sys.exit()
        else:
            print("Please input either Y for Yes or N for No.")

    while True:
        cont = input("Do you want to continue with Voter Registration? Y/N: ").lower()
        if cont == 'y':
            zcode = input("Please input your Zip Code: ")
            if len(zcode) > 5 or len(zcode) < 5:
                zcode = input("This is not a proper 5 digit Zip Code. Please try again: ")
            break
        if cont == 'n':
            print("Thank you for coming!")
            sys.exit()
        else:
            print("Please input either Y for Yes or N for No.")

    print("Thank you for completing the Voter Registration Application.")
    print("Your Voter Registration Card will arrive in 3 weeks.")
    print("Here is your information:")
    print("Name (first, last):", fname.upper(), lname.upper())
    print("Age:", age)
    print("U.S. Citizen:", c_check.upper())
    print("State:", state.upper())
    print("Zipcode: ", zcode)

if __name__ == "__main__":
    v_appli()
