def binary_search(lst, key):
    lst.sort()  # Binary search starts with a sorted list
    left = 0  # The first value of the list
    right = len(lst) - 1  # The last value of the list

    while left <= right:
        middle = (left + right) // 2

        if lst[middle] == key:
            print("Middle element:", middle)
            return middle
        elif lst[middle] > key:
            # add debug print statement here
            print("Checking the left side")
            right = middle - 1
        else:
            # add debug print statement here
            print("Checking the right side")
            left = middle + 1

    return -1


binary_search([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 3)
