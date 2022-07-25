import java.util.Hashtable;
import java.util.Random;

public class ContiguousKSum {
    public static int[] quadratic(int[] a, int k) {
        // Check all the subarrays: quadratic runtime O(N^2)
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (sum == k)
                    return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] linear(int[] a, int k) {
        /* Note that if k exists, we can write k = sum(aj,...,aj+l) for some subarray
         * starting of length l+1, starting from index i = j to index i = j+l
         * The above sum could also be written as t = sum(a0,...,ai) - sum(a0,...,aj-1)
         * The first sum indicates the sum from index 0 to current index i = j+l
         * Since we don't know j, we keep all sums for all j < i
         * These are the prefix sums or complements, and the correct one is 
         * sum(a0,...,aj-1) = sum(a0,...,ai) - t. We know the terms on the RHS, so we can 
         * look up the LHS from a hashtable of prefix sums.
         */

        // Hash prefix sums to allow fast lookup
        Hashtable<Integer, Integer> ht;
        ht = new Hashtable<Integer, Integer>();
        ht.put(0, -1); // Empty prefix sum i.e subarray starts at index 0

        int currentSum = 0;
        for (int i = 0; i < a.length; i++) {
            currentSum += a[i];
            if (ht.containsKey(currentSum - k))
                return new int[]{ht.get(currentSum - k)+1, i}; // k starts after prefix sum.
            ht.put(currentSum, i); // save prefix sums and their end index
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int N = 20;
        int k = 10;
        int[] a = new int[20];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            a[i] = random.nextInt() % 20;
            System.out.printf("%2d ", a[i]);
        }
        System.out.println();

        // In the case of multiple multiple solutions,
        // Quadratic solution will have smallest start index and
        // Linear solution will have smallest end index
        int[] quad = quadratic(a, k);
        int[] linr = linear(a, k);
        System.out.printf("quadratic soln: [%2d, %2d]\n", quad[0], quad[1]);
        System.out.printf("linear    soln: [%2d, %2d]\n", linr[0], linr[1]);
    }
}
