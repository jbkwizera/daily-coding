import java.util.Arrays;
public class Kmerge {
    public static int[] merge(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int[] z = new int[m+n];
        int i = 0;
        int j = 0;
        for (int k = 0; k < m+n; k++) {
            if      (i >= m)      z[k] = b[j++];
            else if (j >= n)      z[k] = a[i++];
            else if (a[i] < b[j]) z[k] = a[i++];
            else                  z[k] = b[j++];
        }
        return z;
    }
    public static int[] merge(int[][] a) {
        if (a.length == 0)
            return new int[0];
        return merge(a, 0, a.length-1);
    }
    private static int[] merge(int[][] a, int lo, int hi) {
        if (hi <= lo) return a[lo];
        int mid = lo + (hi - lo)/2;
        int[] left = merge(a, lo,   mid);
        int[] riht = merge(a, mid+1, hi);
        return merge(left, riht);
    }
    public static void main(String[] args) {
        int N = 0;
        int[][] stream = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                stream[i][j] = StdRandom.uniform(-10000, 10000);
            Arrays.sort(stream[i]);
        }
        int[] z = merge(stream); // all streams merged.
    }
}
