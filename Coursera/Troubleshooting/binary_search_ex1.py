"""doc"""


def find_item(my_list, item):
    my_list = sorted(my_list)
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


def main():
    print(find_item(my_list_of_names, "Alex"))  # True
    print(find_item(my_list_of_names, "Andrew"))  # False
    print(find_item(my_list_of_names, "Drew"))  # True
    print(find_item(my_list_of_names, "Jared"))  # False


if __name__ == "__main__":
    main()
