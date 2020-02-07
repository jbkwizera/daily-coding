public class Multiset {
    public static boolean repeated(int[] a, int N) {
        for (int k = 0; k < N; k++)
            if (a[k] == a[N]) return true;
        return false;
    }
    public static int[] remaining(int[] a, int k) {
        int[] t = new int[a.length-1];
        System.arraycopy(a, 0, t, 0, k);
        System.arraycopy(a, k+1, t, k, a.length-k-1);
        return t;
    }
    public static void permutation(int[] t, int[] a, int i) {
        if (i == t.length) show(t);
        for (int k = 0; k < a.length; k++) {
            if (!repeated(a, k)) {
                t[i] = a[k];
                permutation(t, remaining(a, k), i+1);
            }
        }
    }
    public static void permutation(int[] a)
    {   permutation(new int[a.length], a, 0); }

    public static void show(int[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.printf("%2d ", a[i]);
        StdOut.println();
    }
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(0, 5);

        a = new int[]{1, 1, 2, 2};
        permutation(a);
    }
}
