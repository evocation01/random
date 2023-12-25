"""How to search in python. Linear, binary search"""


def linear_search(my_list, key):
    """If key is in the my_list, returns its position in the my_list, otherwise returns -1."""
    for i, item in enumerate(my_list):
        if item == key:
            return i
    return -1


def binary_search(my_list, key):
    """Returns the position of key in the my_list if found, otherwise -1.
    my_list must be sorted.
    """

    left = 0
    right = len(my_list) - 1
    while left <= right:
        middle = (left + right) // 2

        if my_list[middle] == key:
            return middle
        if my_list[middle] > key:
            return middle - 1
        if my_list[middle] < key:
            return middle + 1
    return -1


def find_item(my_list, item):
    # Returns True if the item is in the my_list, False if not.
    if len(my_list) == 0:
        return False

    # Is the item in the center of the my_list?
    middle = len(my_list) // 2
    if my_list[middle] == item:
        return True

    # Is the item in the first half of the my_list?
    if item < my_list[middle]:
        # Call the function with the first half of the my_list
        return find_item(my_list[:middle], item)
    else:
        # Call the function with the second half of the my_list
        return find_item(my_list[middle + 1 :], item)

    return False


# Do not edit below this line - This code helps check your work!
my_list_of_names = [
    "Parker",
    "Drew",
    "Cameron",
    "Logan",
    "Alex",
    "Chris",
    "Terry",
    "Jamie",
    "Jordan",
    "Taylor",
]


print(find_item(my_list_of_names, "Alex"))  # True
print(find_item(my_list_of_names, "Andrew"))  # False
print(find_item(my_list_of_names, "Drew"))  # True
print(find_item(my_list_of_names, "Jared"))  # False
