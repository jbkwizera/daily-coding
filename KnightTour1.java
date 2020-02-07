public class KnightTour1 {
    public static int N = 8;
    private static final int[] row = {2, 1, -1, -2, -2, -1,  1,  2};
    private static final int[] col = {1, 2,  2,  1, -1, -2, -2, -1};
    private static int COUNT = 0;

    private static boolean validate(int i, int j)
    {   return !(i < 0 || j < 0 || i >= N || j >= N); }

    private static void show(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                StdOut.printf("%3d ", sol[i][j]);
            StdOut.println();
        }
        for (int i = 0; i < N; i++)
            StdOut.print("----");
        StdOut.println();
    }
    public static void findpath(int[][] sol, int i, int j, int cnt) {
        if (sol[i][j] != 0) return;
        sol[i][j] = cnt;
        if (cnt == N*N)
        {  sol[i][j] = 0; COUNT++; return; }

        for (int k = 0; k < 8; k++) {
            int x = i + row[k];
            int y = j + col[k];
            if (validate(x, y)) findpath(sol, x, y, cnt+1);
        }
        sol[i][j] = 0;
    }
    public static void main(String[] args) {
        N = Integer.parseInt(args[0]);
        int[][] sol = new int[N][N];
        findpath(sol, 0, 0, 1);
        StdOut.println(COUNT);
    }
}
