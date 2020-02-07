public class RotatedBinarySearch {
    private static int breakPoint(int[] a, int lo, int hi) {
        if (lo+1 >= hi) {
            if (a[hi] < a[lo]) return hi;
            return -1;
        }
        int k = lo + (hi -lo)/2;
        if (k > 0 && a[k] < a[k-1]) return k;
        int left = breakPoint(a, lo, k);
        if (left != -1) return left;
        return breakPoint(a, k, hi);
    }
    public static int search(int[] a, int T) {
        int k = breakPoint(a, 0, a.length-1);
        if (k < 0) return search(a, T, 0, a.length-1);
        int left = search(a, T, 0, k-1);
        if (left != -1) return left;
        return search(a, T, k, a.length-1);
    }
    private static int search(int[] a, int T, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = (lo + hi) /2;
        if (a[mid] > T) return search(a, T, lo, mid-1);
        if (a[mid] < T) return search(a, T, mid+1, hi);
        return mid;
    }
    public static void main(String[] args) {
        int[] a = {};

        int k = breakPoint(a, 0, a.length-1);
        StdOut.println(k + " " + search(a, 1));
    }
}
