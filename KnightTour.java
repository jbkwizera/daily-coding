public class KnightTour {
    private static int N = 8;
    private static int path = 0;
    private static int[][] sol = new int[N][N];

    public static boolean findpath(int i, int j, int cnt) {
        if (sol[i][j] != 0) return false; // visited.
        sol[i][j] = ++path;
        if (path == N*N) return true;

        // very weird how the ordering of these ifs affects the speed.
        if (validate(i+2, j+1) && findpath(i+2, j+1, cnt+1)) return true;
        if (validate(i+1, j+2) && findpath(i+1, j+2, cnt+1)) return true;
        if (validate(i-1, j+2) && findpath(i-1, j+2, cnt+1)) return true;
        if (validate(i-2, j+1) && findpath(i-2, j+1, cnt+1)) return true;
        if (validate(i-2, j-1) && findpath(i-2, j-1, cnt+1)) return true;
        if (validate(i-1, j-2) && findpath(i-1, j-2, cnt+1)) return true;
        if (validate(i+1, j-2) && findpath(i+1, j-2, cnt+1)) return true;
        if (validate(i+2, j-1) && findpath(i+2, j-1, cnt+1)) return true;
        // every knight position is occupied. so backtrack.
        sol[i][j] = 0;
        path--;
        return false;
    }
    private static boolean validate(int i, int j)
    {   return i >= 0 && i < N && j >= 0 && j < N; }

    public static void show(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                StdOut.printf("%2d ", sol[i][j]);
            StdOut.println();
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol  = new int[N][N];
                path = 0;
                if (findpath(i, j, 0)) {
                    show(sol);
                    StdOut.println("--------------------");
                }
                else StdOut.println("nothing found!");
            }
        }
    }
    //909 564 3834
}
