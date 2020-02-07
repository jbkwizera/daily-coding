import sys

row = [2, 1, -1, -2, -2, -1,  1,  2]
col = [1, 2,  2,  1, -1, -2, -2, -1]
N   = int(sys.argv[1])
COUNT = 0

def _travel(sol, i, j, cnt):
    if sol[i][j] != 0:
        return
    sol[i][j] = cnt
    if cnt == N*N:
        global COUNT
        sol[i][j] = 0
        COUNT += 1
        return

    for k in range(8):
        x = i + row[k]
        y = j + col[k]
        if 0 <= x < N and 0 <= y < N:
            _travel(sol, x, y, cnt+1)
    sol[i][j] = 0;

def travel(n):
    global N
    N = n
    a = [[0 for i in range(n)] for j in range(n)]
    _travel(a, 0, 0, 1)

if __name__ == '__main__':
    travel(N)
    print(COUNT)
