public class EfficientNQueens {
    private static int count;
    public static int[] remaining(int[] a, int k) {
        int[] t = new int[a.length-1];
        System.arraycopy(a, 0, t, 0, k);
        System.arraycopy(a, k+1, t, k, a.length-k-1);
        return t;
    }
    // check diags.
    public static boolean isValid(int[] t, int x, int y) {
        for (int i = 0; i < y; i++)
            if (Math.abs(t[i]-x) == Math.abs(i-y))
                return false;
        return true;
    }
    // basically just permutations.
    public static void arrangement(int[] t, int[] a, int i) {
        if (i == t.length) count++;
        for (int k = 0; k < a.length; k++)
            // add a queen iff it doesn't cause issues.
            if (isValid(t, a[k], i))
            {   t[i] = a[k]; arrangement(t, remaining(a, k), i+1); }
    }
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        for (int N = 1; N <= T; N++) {
            count = 0;
            int[] a = new int[N];
            for (int i = 0; i < N; i++)
                a[i] = i;

            Stopwatch s = new Stopwatch();
            arrangement(new int[N], a, 0);
            StdOut.printf("N: %2d  count: %7d time: %8.5f\n", N, count, s.elapsedTime());
        }
    }
}
