
# returns a function that takes a function!
def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair

# takes a function that takes as argument
# a function w/ 2 args that returns the 1st arg
def car(cns):
    return cns(lambda a, b: a)

# takes a function that takes as argument
# a function w/ 2 args that returns the 2nd arg
def cdr(cns):
    return cns(lambda a, b: b) 

if __name__ == "__main__":
    print(car(cons(3, 4)))
    print(cdr(cons(3, 4)))

