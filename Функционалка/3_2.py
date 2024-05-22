import math

def numer(x):
    g = math.gcd(x[0], x[1])
    return x[0] // g

def denom(x):
    g = math.gcd(x[0], x[1])
    return x[1] // g

def make_rat(n, d):
     return n, d

def add_rat(x, y):
    n = numer(x) * denom(y) + numer(y) * denom(x)
    d = denom(x) * denom(y)
    return make_rat(n, d)

num1 = make_rat(1,6)
num2 = make_rat(1,7)

result = add_rat(num1, num2)
print(f"{numer(num1)}/{denom(num1)} + {numer(num2)}/{denom(num2)} = {numer(result)}/{denom(result)}")





