public class Sudoku {
    public static boolean inBlock(int[][] puz, int v, int m, int n) {
        for (int i = m-3; i < m; i++)
            for (int j = n-3; j < n; j++)
                if (puz[i][j] == v) return true;
        return false;
    }
    public static boolean full(int[][] puz, int[] nxt) {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (puz[i][j] == 0)
                {   nxt[0] = i; nxt[1] = j; return false; }
        return true;
    }
    public static boolean canUse(int[][] puz, int v, int r, int c) {
        int N = 9;
        for (int i = 0; i < N; i++)
            if (puz[i][c] == v || puz[r][i] == v)
                return false;

        if      (r < 3 && c < 3) { if (inBlock(puz, v, 3, 3)) return false; }
        else if (r < 3 && c < 6) { if (inBlock(puz, v, 3, 6)) return false; }
        else if (r < 3 && c < 9) { if (inBlock(puz, v, 3, 9)) return false; }
        else if (r < 6 && c < 3) { if (inBlock(puz, v, 6, 3)) return false; }
        else if (r < 6 && c < 6) { if (inBlock(puz, v, 6, 6)) return false; }
        else if (r < 6 && c < 9) { if (inBlock(puz, v, 6, 9)) return false; }
        else if (r < 9 && c < 3) { if (inBlock(puz, v, 9, 3)) return false; }
        else if (r < 9 && c < 6) { if (inBlock(puz, v, 9, 6)) return false; }
        else if (r < 9 && c < 9) { if (inBlock(puz, v, 9, 9)) return false; }
        return true;
    }
    public static void solve(int[][] puz) {
        int[] nxt = new int[2];
        if (full(puz, nxt))
        { show(puz); return; }
        int i = nxt[0], j = nxt[1];
        for (int v = 1; v < 10; v++) {
            if (canUse(puz, v, i, j)) {
                puz[i][j] = v;
                solve(puz);
                puz[i][j] = 0;
            }
        }
    }
    public static void show(int[][] a) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                StdOut.printf("%2d ", a[i][j]);
            StdOut.println();
        }
    }
    public static void main(String[] args) {
        int[][] a = {
            { 0, 0, 0, 0, 0, 0, 4, 0, 0},
            { 3, 0, 6, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 1, 9, 6, 0, 3, 0},
            { 0, 7, 0, 0, 0, 0, 0, 1, 0},
            { 8, 0, 0, 2, 5, 0, 0, 9, 0},
            { 0, 4, 0, 0, 0, 0, 8, 0, 0},
            { 0, 6, 0, 4, 0, 9, 0, 0, 8},
            { 0, 0, 5, 0, 0, 0, 0, 2, 0},
            { 0, 0, 0, 5, 0, 0, 0, 0, 7}
        };
        solve(a);
    }
}
