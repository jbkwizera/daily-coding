public class ClockwiseArray {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        int[][] a = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                a[i][j] = M*i + j + 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                StdOut.printf("%2d ", a[i][j]);
            StdOut.println();
        }
        StdOut.println("---------");


        for (int i = 0, j = 0; i <= N/2 && j <= M/2; i++, j++) {
            for (int k = j; k < M-j; k++)
                StdOut.println(a[i][k]);
            for (int k = i+1; k < N-i; k++)
                StdOut.println(a[k][M-j-1]);
            for (int k = M-j-2; k >= j; k--)
                StdOut.println(a[N-i-1][k]);
            for (int k = N-i-2; k > i; k--)
                StdOut.println(a[k][j]);
        }
    }
}
/*****************
00 01 02 03 04
10
sugar rush
every citizen has a coin
and they throw them at the selector
choose 6 random citizens.
you don't know how many citizens there are.
// stream---random-reservoir shit


*/
