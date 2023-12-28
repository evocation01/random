import re


def rearrange_name(name):
    result = re.search(r"^(\w*),\s+(.*)$", name)
    if result is None:
        return name
    return result.group(2) + " " + result.group(1)


if __name__ == "__main__":
    name = input("What's your name? ")
    print(rearrange_name(name))
