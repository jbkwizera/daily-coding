import java.util.*;
public class Inversion {
    private static int[] aux;
    private static int merge(int[] a, int lo, int mid, int hi) {
        int i = lo, j = mid+1, invCount = 0;
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)           a[k] = aux[j++];
            else if (j >  hi)           a[k] = aux[i++];
            else if (aux[i] <= aux[j])  a[k] = aux[i++];
            else { invCount += mid-i+1; a[k] = aux[j++]; }
        }
        return invCount;
    }
    private static int count(int[] a, int lo, int hi) {
        if (lo >= hi) return 0;
        int mid = (lo + hi) /2;
        int invCount = count(a, lo, mid);
        invCount += count(a, mid+1, hi);
        invCount += merge(a, lo, mid, hi);
        return invCount;
    }
    public static int count(int[] a) {
        aux = new int[a.length];
        return count(a, 0, a.length-1);
    }
    public static void main(String[] args) {
        int[] a = {1, 20, 6, 4, 5};
        StdOut.println(count(a));
        StdOut.println(Arrays.toString(a));
        StdOut.println(Math.ceil((4 + 3)/2.0));
    }
}
