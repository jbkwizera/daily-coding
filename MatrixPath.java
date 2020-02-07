public class MatrixPath {
    public static int recurse(int m, int n) {
        if (m == 1 || n == 1) return 1;
        return recurse(m-1, n) + recurse(m, n-1);
    }
    public static int dynamic(int m, int n) {
        int[] a = new int[n+1];
        for (int j = 1; j <= n; j++)
            a[j] = 1;

        for (int i = 2; i <= m; i++)
            for (int j = 2; j <= n; j++)
                a[j] += a[j-1];
        return a[n];
    }
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);
        StdOut.println(recurse(M, N) + " | " + dynamic(M, N));
    }
}
