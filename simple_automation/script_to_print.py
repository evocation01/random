"""Adding a print function for easier use later:"""


def print_func(name):
    """code"""
    if name == r"(\w), (\w)":
        name = r"g<2> g<1>"

    print(f"hello, {name}")


def main():
    """Test cases"""
    print_func("İspir, Hakan")


if __name__ == "__main__":
    main()
