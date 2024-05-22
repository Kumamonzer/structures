
def f1(a, b):
    return b/a**3

def f2(s, a, b):
    if s == "+":
        return a + b
    elif s == "-":
        return a - b
    elif s == "/":
        return a / b
    elif s == "*":
        return a * b
    else:
        return Exception("Error: incorrect operator")
    

def result(oper, a, b, k, fun1, fun2):
    res = 0
    for i in range(k):
        if i == 0:
            res = f1(a, b)
            a+=2
            b+=1
        else:
            res = fun2(oper, res, fun1(a, b))
            a+=2
            b+=1 
    return res

print(result("+", 3, 1, 3, f1, f2))

