def aplusb17(a, diff):
    comps = set()
    for x in a:
        if x in comps:
            return True
        comps.add(diff-x)
    return False

if __name__ == '__main__':
    a = [11, 15, 3, 6]
    print(aplusb17(a, 9))
