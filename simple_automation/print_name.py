"""Creating a custom print function to print names, for easier use later:"""

import re


def print_name_func(name="world"):
    """code"""
    pattern = re.compile(r"(\w+), (\w+)")

    if pattern.match(name):
        name = re.sub(pattern, r"\2 \1", name)
    print(f"hello, {name}")


def main():
    """Test cases"""
    print_name_func("İspir, Hakan")  # Hakan İspir
    print_name_func("İspir Hakan")  # İspir Hakan
    print_name_func("Hakan İspir")  # Hakan İspir
    print_name_func("Hakan")  # Hakan
    print_name_func()


if __name__ == "__main__":
    main()
