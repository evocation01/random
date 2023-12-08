"""Some examples of never using comprehensions."""


def never_using_comprehensions():
    """Some comprehension examples."""
    # pylint: disable=unused-variable
    dict_comp = {i: i * i for i in range(10)}
    list_comp = [x * x for x in range(10)]
    set_comp = {i % 3 for i in range(10)}
    gen_comp = (2 * x + 5 for x in range(10))
    # pylint: enable=unused-variable


def always_using_comprehensions(a, b, n):
    """matrix product of a, b of length n x n"""
    return [
        sum(a[n * i + k] * b[n * k + j] for k in range(n))
        for i in range(n)
        for j in range(n)
    ]


def instead_use_this(a, b, n):
    """matrix product of a, b of length n x n"""
    c = []
    for i in range(n):
        for j in range(n):
            ij_entry = sum(a[n * i + k] * b[n * k + j] for k in range(n))
            c.append(ij_entry)
    return c
