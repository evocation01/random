"""Creating a custom print name function/script"""

import re


def print_name_func(name="world"):
    """code"""
    pattern = re.compile(r"(\w+), (\w+)")

    if pattern.match(name):
        name = re.sub(pattern, r"\2 \1", name)
    print(f"hello, {name}")


def main():
    """Main function"""
    test_cases()


def test_cases():
    """Some basic test cases for the script"""
    assert print_name_func("İspir, Hakan") == "hello, Hakan İspir"
    assert print_name_func("İspir Hakan") == "hello, İspir Hakan"
    assert print_name_func("Hakan İspir") == "hello, Hakan İspir"
    assert print_name_func("Hakan") == "hello, Hakan"
    assert print_name_func() == "hello, world"


if __name__ == "__main__":
    main()
