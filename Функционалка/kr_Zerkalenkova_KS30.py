import math

def hr(a):
    return a**2 + 3*a + 5

def hc(a):
    return a**3 - 2*a + 7

def kr(a):
    return math.sqrt(2*a)

def kc(a):
    return math.log(3*a)

def pump(func_p, func_q):
    def calculate(p, q):
        return func_p(p)*func_q(q) + 1.25
    return calculate

calc_x_func = pump(hr, kr)
calc_y_func = pump(hc, kc)

p_value = 3
q_value = 12
print("Насос 1: ", calc_x_func(p_value, q_value))
print("Насос 2: ", calc_y_func(p_value, q_value))