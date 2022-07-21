public class Goldbach {
    public static boolean[] list(int N) {
        boolean[] a = new boolean[N+1];
        for (int i = 2; i <= N; i++)
            a[i] = true;
        for (int i = 2; i <= N; i++)
            if (a[i])
                for (int j = i; j <= N/i; j++)
                    a[i*j] = false;
        return a;
    }

    public static void main(String[] args) {
        int w = args[0].length();
        int N = Integer.parseInt(args[0]);
        
        String formatter = "Prime pair for N = %" + w + "d = %" + w + "d + %" + w + "d\n";
        boolean[] isPrime = list(N);
        for (int p = 2; p <= N-p; p++)
            if (isPrime[p] && isPrime[N-p])
                System.out.printf(formatter, N, p, N-p);
    }
}
