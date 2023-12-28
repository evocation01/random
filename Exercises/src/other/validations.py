def validate_user(username, minlen):
    assert type(username) == str, "username must be a string!"

    if minlen < 1:
        raise ValueError("minimum length cannot be less than 1")
    if len(username) < minlen:
        return False
    if not username.isalnum():
        return False
    return True


if __name__ == "__main__":
    result = validate_user(555, 1)
    print(result)
