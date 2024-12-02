def example_function(a, b):
    if a > 0 and b > 0:
        print("Both are positive")
        print("Done")
        return True
    elif a < 0 or b < 0:
        print("One or both are negative")
        return False
    else:
        print("Neither positive nor negative")
        return None
