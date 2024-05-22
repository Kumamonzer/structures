import math

def numer(x):
    g = math.gcd(x[0], x[1])
    return x[0] // g

def denom(x):
    g = math.gcd(x[0], x[1])
    return x[1] // g

def make_rat(n, d, f1, f2):
    return (n, d), f1, f2

num1, f1, f2 = make_rat(8, 6, numer, denom)
print(f1(num1))
print(f2(num1))