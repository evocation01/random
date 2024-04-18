"""Creating a custom print name function/script"""

import re


def hello_name(name: str):
    """code"""
    pattern = re.compile(r"(\w+), (\w+)")

    if pattern.match(name):
        name = re.sub(pattern, r"\2 \1", name)
    return f"hello, {name}"


def main():
    """Main function"""
    hello_name(name=name)
    print(hello_name(name))


if __name__ == "__main__":
    main()
