def rangeClosed(start, stop, step=1):
	return range(start, stop+1, step)

def calculate_the_cube (n):
	return n**3

def fahrenheit_to_celcius (x):
	return (x-32)*5/9

def celcius_to_kelvin (x):
	return x+273.15

def countdown_from_X_to_zero (start):
	if start == 0:
		 print("Cannot count down to 0")
	else:
		 print("Counting down to 0: ", end="")

	for x in range(start, -1, -1):
		 if (x == 0):
					print(x, end="")
		 elif (x != 0):
					print(x, end=", ")

def factorial_of_a_number (n):
	result = 1
	for x in range(1,n+1):
		result = result * x
	print(result)

def odd_numbers_from1to_X(maximum):
	if maximum == 0:
		print(end="")
	else:
		for x in range(1, maximum + 1, 2):
			print(x, end=" ")

def is_palindrome (input_string):
	# Remove spaces and convert to lowercase
	input_string = input_string.replace(" ", "").lower()
	# Check if the reversed string is equal to the original string
	return input_string == input_string[::-1]

def count_letters_in_a_text (text):
	result = {}
	for letter in text:
		if letter not in result:
			result[letter]=0
		result[letter] = 1
	return result