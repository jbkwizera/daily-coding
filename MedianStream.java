import java.util.ArrayList;
public class MedianStream {
    public static int select(int[] a, int N, int k) {
        int lo = 0, hi = N;
        while (hi > lo) {
            int j = partition(a, lo, hi);
            if      (j == k) return a[k];
            else if (j > k)  hi = j - 1;
            else if (j < k)  lo = j + 1;
        }
        return a[k];
    }
    private static int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi+1;
        int v = a[lo];
        while (true) {
            while (a[++i] < v) if (i == hi) break;
            while (a[--j] > v) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    private static void exch(int[] a, int i, int j)
    {   int temp = a[i]; a[i] = a[j]; a[j] = temp; }

    public static double median(int[] a, int N) {
        if (N % 2 == 1) return select(a, N, N/2);
        return (select(a, N, N/2) + select(a, N, N/2 + 1))/2.0;
    }
    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();

        for (int hi = 0; hi < a.length; hi++) {
            median(a, hi);
            StdOut.println(a[hi/2]);
        }
    }
}
