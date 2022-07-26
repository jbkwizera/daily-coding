import java.util.Random;

public class ProductExceptMe {
    public static int[] quadratic(int[] a) {
        // Bruteforce quadratic solution w/out division.
        int N = a.length;
        int[] res = new int[N];
        java.util.Arrays.fill(res, 1);

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (j != i)
                    res[i] *= a[j];
        return res;
    }
    public static int[] linear1(int[] a) {
        // "Bruteforce" linear solution. Find the product of all elements
        // Then divide it by the i-th value. Trouble with this approach is
        // it doesn't work if one of the values is 0.
        int N = a.length;
        int[] res = new int[N];

        int product = 1;
        for (int i = 0; i < N; i++)
            product *= a[i];

        for (int i = 0; i < N; i++)
            res[i] = product/a[i];
        return res;
    }
    public static int[] linear2(int[] a) {
        // Linear solution without division
        // Main idea is to create forward-way and backward-way products.
        // Then forward[i-1] * backward[i+1] is the product that excludes
        // the i-th index value.
        
        int N = a.length;
        int[] res = new int[N];
        int[] forward  = new int[N+2];
        int[] backward = new int[N+2];
        forward[0]  = forward[N+1]  = 1;
        backward[0] = backward[N+1] = 1;
        for (int i = 1; i <= N; i++) {
            forward[i]      = forward[i-1] * a[i-1];
            backward[N-i+1] = backward[N-i+2] * a[N-i];
        }
        for (int i = 1; i <= N; i++)
            res[i-1] = forward[i-1] * backward[i+1];
        return res;
    }

    public static void main(String[] args) {
        int N = 10;
        int[] a = new int[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            while (a[i] == 0)
                a[i] = random.nextInt() % 5;
            System.out.printf("%6d ", a[i]);
        }
        System.out.println();

        System.out.println("Quadratic brute force sln");
        int[] quad = quadratic(a);
        for (int i = 0; i < N; i++)
            System.out.printf("%6d ", quad[i]);
        System.out.println();

        System.out.println("Linear brute force sln");
        int[] lin1 = linear1(a);
        for (int i = 0; i < N; i++)
            System.out.printf("%6d ", lin1[i]);
        System.out.println();

        System.out.println("Linear no div. sln");
        int[] lin2 = linear2(a);
        for (int i = 0; i < N; i++)
            System.out.printf("%6d ", lin2[i]);
        System.out.println();
    }
}
