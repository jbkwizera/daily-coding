def can_hop_2last(a):
    N = len(a)
    i = 0
    while i < N-1 and a[i]:
        i += a[i]
    return i == N-1

if __name__ == '__main__':
    a = [2, 0, 1, 0]
    print(can_hop_2last(a))
