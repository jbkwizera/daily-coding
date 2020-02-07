import java.util.*;
public class Permutation {
    private static int[] remaining(int[] a, int k) {
        int[] t = new int[a.length-1];
        System.arraycopy(a, 0, t, 0, k);
        System.arraycopy(a, k+1, t, k, a.length-k-1);
        return t;
    }
    // avoid repeating permutations
    private static boolean repeated(int[] a, int v, int N) {
        for (int i = 0; i < N; i++)
            if (a[i] == v) return true;
        return false;
    }
    public static void permuts(int[] t, int[] a, int i) {
        if (i == t.length) show(t);
        for (int k = 0; k < a.length; k++) {
            if (!repeated(a, a[k], k))
            { t[i] = a[k]; permuts(t, remaining(a, k), i+1); }
        }
    }
    public static void show(int[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.printf("%2d ", a[i]);
        StdOut.println();
    }
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = i;
        permuts(new int[N], a, 0);
    }
}
