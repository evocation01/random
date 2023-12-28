"""Maths functions that can be imported for easy use later"""


def cube(n):
    """returns cube"""
    return n**3


def fahrenheit_to_celcius(x):
    """useful to convert *F to *C"""
    return (x - 32) * 5 / 9


def celcius_to_kelvin(x):
    """useful to convert *C to *K"""
    return x + 273.15


def countdown(start):
    """countdown from x to zero"""
    if start == 0:
        print("Cannot count down to 0")
    else:
        print("Counting down to 0: ", end="")

    for x in range(start, -1, -1):
        if x == 0:
            print(x, end="")
        elif x != 0:
            print(x, end=", ")


def factorial(n):
    """takes the nth factorial"""
    result = 1
    for x in range(1, n + 1):
        result = result * x
    print(result)


def print_all_odds(vom, bis):
    """prints all the odd numbers from vom to bis"""
    if bis == 0:
        print(end="")
    else:
        for x in range(vom, bis + 1, 2):
            print(x, end=" ")


def is_palindrome(input_string):
    """returns true if the input string is a palindrome"""
    # Remove spaces and convert to lowercase
    input_string = input_string.replace(" ", "").lower()
    # Check if the reversed string is equal to the original string
    return input_string == input_string[::-1]


def count_letters_in_a_text(text):
    """counts the number of letters in a text"""
    result = {}
    for letter in text:
        if letter not in result:
            result[letter] = 0
        result[letter] = 1
    return result


def even_numbers(first, last):
    """returns a list of even numbers from the first number to last, both included."""
    return [
        even_number for even_number in range(first, last + 1) if even_number % 2 == 0
    ]
