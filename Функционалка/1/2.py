def sum(term, a, next, b):
    def iter(a, result):
        if a > b:
            return result
        return iter(next(a), result + term(a))
    
    return iter(a, 0)

def square(x):
    return x * x

def identity(x):
    return x

def inc(x):
    return x + 1

print(sum(identity, 4, square, 5))