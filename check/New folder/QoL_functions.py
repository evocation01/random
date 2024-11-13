def definite_len(word):
	if len(word) > 0:
		return len(word)
	else:
		return 0

print(definite_len("a")) # Should print 1
print(definite_len("This is a long string")) # Should print 21
print(definite_len("Monday")) # Should print 6
print(definite_len("")) # Should print 0


def even_numbers(first, last):
	return [even_number for even_number in range(first,last) if even_number % 2 == 0]


print(even_numbers(4, 14)) # Should print [4, 6, 8, 10, 12]
print(even_numbers(0, 9))  # Should print [0, 2, 4, 6, 8]
print(even_numbers(2, 7))  # Should print [2, 4, 6]