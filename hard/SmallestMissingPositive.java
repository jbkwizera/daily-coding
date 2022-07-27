import java.util.Random;

public class SmallestMissingPositive {
    public static int find(int[] a) {
        // Push non-positives to the back. N will be the
        // number of positive integers in a at the end
        int N = a.length;
        for (int i = a.length-1; i >= 0; i--)
            if (a[i] <= 0) 
            {   int t = a[i]; a[i] = a[--N]; a[N] = t; } 

        for (int i = 0; i < N; i++) {
            int j = Math.abs(a[i]) - 1; // index corresp. to the current value
            if (j <= N && a[j] > 0) // if value is in range and not marked
                a[j] = -a[j];   // mark the value's index as negative
        }

        // Return first positive index i. It's missing since it wasn't marked
        // in the index-value mapping
        for (int i = 0; i < N; i++)
            if (a[i] > 0) return i+1;

        // There were no dups or positive integers. Return next smallest +ve  
        return N+1;
    }

    public static void main(String[] args) {
        int N = 20;
        int[] a = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            a[i] = -5 + random.nextInt(25);
            System.out.printf("%2d ", a[i]);
        }
        System.out.println();
        System.out.println("Smallest missing +ve integer: " + find(a));
    }
}
