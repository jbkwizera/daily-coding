import java.util.HashSet;
public class Occur3Times {
    public static void show(int[] a) {
        for (int x: a)
            StdOut.print(x + " ");
        StdOut.println();
    }
    public static int[] data(int N) {
        HashSet<Integer> seen = new HashSet<Integer>();
        int[] a = new int[N];
        a[0] = StdRandom.uniform(N);
        for (int i = 1; i < N; i += 3) {
            seen.add(a[i-1]);
            int x = StdRandom.uniform(N);
            while (x == 0 || seen.contains(x))
                x = StdRandom.uniform(N);
            for (int j = 0; j < 3; j++)
                a[i+j] = x;
        }
        return a;
    }
    public static void main(String[] args) {
        for (int N = 4; N < 1000; N += 3) {
            int[] a = data(N);
            if (a[0] != eval(a) && N < 50) {
                show(a);
                break;
            }
        }
    }
    public static int eval(int[] a) {
        int total3Sum = 0;
        for (int x: a) total3Sum += x; // total sum

        int uniqueSum = 0;
        int check     = 0;
        for (int x: a) {
            if ((check & (1 << x)) == 0)    // not seen before.
            {   uniqueSum += x; check |= (1 << x); }
        }
        return (3*uniqueSum - total3Sum)/2;
    }
}
