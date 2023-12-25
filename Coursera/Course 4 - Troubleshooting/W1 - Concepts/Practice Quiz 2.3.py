import re


def compare_strings(string1, string2):
    # Convert both strings to lowercase
    # and remove leading and trailing blanks
    string1 = string1.lower().strip()
    string2 = string2.lower().strip()

    # Ignore punctuation
    punctuation = r"[.?!,;:']"  # re.error: bad character range :-' at position 6

    string1 = re.sub(punctuation, r"", string1)
    string2 = re.sub(punctuation, r"", string2)

    # DEBUG CODE GOES HERE

    result = string1 == string2
    return result


print(compare_strings("Have a Great Day!", "Have a great day?"))  # True
print(compare_strings("It's raining again.", "its raining, again"))  # True
print(
    compare_strings("Learn to count: 1, 2, 3.", "Learn to count: one, two, three.")
)  # False
print(compare_strings("They found some body.", "They found somebody."))  # False
