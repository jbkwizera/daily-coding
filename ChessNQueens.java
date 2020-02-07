public class ChessNQueens {
    private static int count = 0;
    // terrible way to check if a queen's attack!
    public static boolean conflicting(boolean[][] occupied, int x, int y) {
        // forward diag.
        int N = occupied.length;
        int i = x-1, j = y+1;
        while (i >= 0 && j < N)
            if (occupied[i--][j++]) return true;

        i = x+1; j = y-1;
        while (i < N && j >= 0)
            if (occupied[i++][j--]) return true;

        // backward diag.
        i = x-1; j = y-1;
        while (i >= 0 && j >= 0)
            if (occupied[i--][j--]) return true;

        i = x+1; j = y+1;
        while (i < N && j < N)
            if (occupied[i++][j++]) return true;
        return false;
    }
    public static boolean isValid(int[] perm) {
        int N = perm.length;
        boolean[][] occupied = new boolean[N][N];
        for (int i = 0; i < N; i++)
            occupied[perm[i]][i] = true;

        for (int i = 0; i < N; i++)
            if (conflicting(occupied, perm[i], i))
                return false;
        return true;
    }
    public static void exch(int[] a, int i, int j)
    {   int temp = a[i]; a[i] = a[j]; a[j] = temp; }

    // using a heap to generate all permutations.
    public static void heapPermuts(int a[], int sz) {
        if (sz == 1)
            if (isValid(a)) count++;
        for (int i = 0; i < sz; i++) {
            heapPermuts(a, sz-1);
            if (sz % 2 == 1) exch(a, 0, sz-1);
            else             exch(a, i, sz-1);
        }
    }
    // normal way to generate permuts allows room for improvement
    public static boolean defective(int[] t, int v, int i) {
        if (i == 0) return false;
        return v+1 == t[i-1] || v-1 == t[i-1];
    }
    public static int[] remaining(int[] a, int k) {
        int[] t = new int[a.length-1];
        System.arraycopy(a, 0, t, 0, k);
        System.arraycopy(a, k+1, t, k, a.length-k-1);
        return t;
    }
    public static void normPermuts(int[] t, int[] a, int i) {
        if (i == t.length)
            if (isValid(t)) count++;
        for (int k = 0; k < a.length; k++) {
            if (!defective(t, a[k], i)) {
                t[i] = a[k];
                normPermuts(t, remaining(a, k), i+1);
            }
        }
    }
    public static void main(String[] args) {
        int v = Integer.parseInt(args[0]);
        for (int N = 1; N <= v; N++) {
            count = 0;
            int[] a = new int[N];
            for (int i = 0; i < N; i++)
                a[i] = i;

            Stopwatch s = new Stopwatch();
            normPermuts(new int[N], a, 0);
            StdOut.printf("N: %2d  count: %7d  time: %8.5f\n", N, count, s.elapsedTime());
        }
    }
}
