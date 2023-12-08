"""Some examples of never using comprehensions."""


def never_using_comprehensions():
    """Some comprehension examples."""
    # pylint: disable=unused-variable
    dict_comp = {i: i * i for i in range(10)}
    list_comp = [x * x for x in range(10)]
    set_comp = {i % 3 for i in range(10)}
    gen_comp = (2 * x + 5 for x in range(10))
    # pylint: enable=unused-variable
