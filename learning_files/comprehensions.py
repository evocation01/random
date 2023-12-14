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


# pylint: disable=pointless-string-statement
"""
i-u case:
    # Reason: Liskov principle #

    instead of: 
        type(p) == tuple
    use:
        isinstance(p, tuble)

i-u case:
    instead of:
        == (x == None)
    use:
        is (x is None)

i-u case:
    instead of:
        x == True
    use:
        x

i-u case:
    instead of:
        for i in range(len(a)):
            v = a[i]
    use:
        for v in a:
            ...
        for i, v in enumerate(a):
            ...

i-u case:
    instead of:
        for i in range(len(b)):
            av = a[i]
            bv = b[i]
    use:
        for av, bv in zip(a,b):
            ...

    use:    
        for i, (av, bv) in enumerate(zip(a,b)):
            ...

i-u case:
    instead of:
        for key in d:
            val = d[key]
    use:
        for key, val in d.items():
            ...

# tuple_unpacking
i-u case: 
    instead of:
        x = mytuple[0]
        y = mytuple[1]
    use:
        x, y = mytuple

# index_counter_var
i-u case:
    instead of:
        l = [1,2,3]
        
        i = 0
        for x in l:
            ...
            i += 1

    use:
        l = [1,2,3]
        
        for i, x in enumerate(l):
            ...
    
i-u case:
    instead of:
        time.time()
    use:
        time.perf_counter()

    # more accurate

i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:
    
i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:
    
i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:
    
i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:
    
i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:
    
i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:
    
i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:
    
i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:
    
i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:
    
i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:
    
i-u case:
    instead of:
        
    use:

i-u case:
    instead of:
        
    use:   
"""
