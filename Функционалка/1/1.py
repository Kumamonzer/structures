def square_power(base, exponent):
    def even(exponent):
        return exponent % 2 == 0
    a = 1
    if not even(exponent):
       a = base
       exponent-=1
    while exponent!=1:
        base *= base
        exponent /= 2
        base *= a
        return base


number = 5
result = square_power(number, 2)
print(f'{number} в квадрате равно {result}')

