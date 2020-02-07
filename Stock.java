public class Stock {
    public static int[] bestDeal(int[] a, int lo, int hi) {
        if (lo >= hi) return new int[]{0, a[lo], a[lo]};
        int mid = lo + (hi - lo)/2;
        int[] L = bestDeal(a, lo, mid);
        int[] R = bestDeal(a, mid+1, hi);

        if (R[2]-L[1] > Math.max(R[0], L[0]))
            return new int[]{R[2]-L[1], L[1], R[2]};
        if (R[0] > L[0]) return R;
        if (R[0] < L[0]) return L;

    }
    public static int bestDeal(int[] a)
    {   return bestDeal(a, 0, a.length-1)[0]; }

    public static void main(String[] args) {
        int[] a = {9, 11, 17, 8, 5, 6, 7, 10};
        int x = bestDeal(a);
        StdOut.println(x);
    }
}
