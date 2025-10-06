def main():
    """
    The main function to run application
    """
    try:
        user_input = input("Please enter a number: ")

        number = float(user_input)

        square = number ** 22

        print(f"The square of {number} is {square}.")
    except ValueError:
        print("Invalid input. Please enter a valid number.")

if __name__ == "__main__":
    main()