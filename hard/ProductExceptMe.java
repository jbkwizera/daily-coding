import java.util.Random;

public class ProductExceptMe {
    public static int[] quadratic(int[] a) {
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
        int N = a.length;
        int[] res = new int[N];
        int[] forward = new int[N];
        int[] backward = new int[N];
        forward[0] = a[0];
        backward[N-1] = a[N-1];
        for (int i = 1; i < N-1; i++) {
            forward[i] = a[i] * forward[i-1];
            backward[N-i-1] = a[N-i-1] * backward[N-i];
        }

        res[0] = backward[1];
        res[N-1] = forward[N-2];
        for (int i = 1; i < N-1; i++)
            res[i] = forward[i-1] * backward[i+1];
        return res;

        // a          1,     2,    3,     4,      5
        // foward     1,     2,    6,    24,    120
        // backward 120,   120,   60,    20,      5
    }

    public static void main(String[] args) {
        int N = 5;
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
