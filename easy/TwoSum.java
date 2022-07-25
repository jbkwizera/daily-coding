import java.util.Hashtable;
import java.util.Random;

public class TwoSum {
    public static int[] quadratic(int[] a, int k) {
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a.length; j++)
                if (i != 0 && a[i] + a[j] == k)
                    return new int[]{i, j};
        return new int[]{-1, -1};
    }
    public static int[] linear(int[] a, int k) {
        // Check if a number has a complement hashed. If not hash
        // the number since it might be a complement of a later number
        Hashtable<Integer, Integer> ht;
        ht = new Hashtable<Integer, Integer>();
        for (int i = 0; i < a.length; i++) {
            if (ht.containsKey(k - a[i]))
                return new int[]{ht.get(k - a[i]), i};
            ht.put(a[i], i);
        }
        return new int[]{-1, -1};
    }
    public static void main(String[] args) {
        int N = 20;
        int k = 20;
        int[] a = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            a[i] = random.nextInt() % 20;
            System.out.printf("%2d ", a[i]);
        }
        System.out.println();
        
        int[] quad = quadratic(a, k);
        int[] linr = linear(a, k);
        System.out.printf("Quadratic soln: [%2d, %2d]\n", quad[0], quad[1]);
        System.out.printf("Linear    soln: [%2d, %2d]\n", linr[0], linr[1]);
    }
}

