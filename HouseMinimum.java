public class HouseMinimum {
    private static int min = Integer.MAX_VALUE;
    public static int mincost1(int[][] a) {
        mincost(a, 0, -1, 0, 0);
        return min;
    }
    public static void mincost(int[][] a, int i, int prev, int cnt, int sum) {
        if (i == a.length) {
            min = Math.min(min, sum);
            return;
        }
        int cost = a[i][0];
        int indx = 0;
        int cnt1 = 0;
        for (int k = 0; k < a[0].length; k++)
            if ((cnt > 1 || k != prev) && a[i][k] < cost)
            {   indx = k; cost = a[i][k]; }

        for (int k = 0; k < a[0].length; k++)
            if (a[i][k] == cost) cnt1++;

        mincost(a, i+1, indx, cnt1, sum+cost);
    }
    public static int mincost2(int[][] a) {
        mincost(a, 0, -1, 0);
        return min;
    }

    public static void mincost(int[][] a, int i, int prev, int sum) {
        if (i == a.length) {
            min = Math.min(min, sum);
            return;
        }
        for (int k = 0; k < a[0].length; k++)
            if (k != prev)
                mincost(a, i+1, k, sum+a[i][k]);
    }
    public static void show(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++)
                StdOut.printf("%2d ", a[i][j]);
            StdOut.println();
        }
    }
    public static void main(String[] args) {

        int N = StdIn.readInt(); //Integer.parseInt(args[0]);
        int K = StdIn.readInt(); //Integer.parseInt(args[1]);
        int[][] a = new int[N][K];
        for (int i = 0; i < N; i++)
            for (int k = 0; k < K; k++)
                a[i][k] = StdIn.readInt(); //StdRandom.uniform(1, 10);
        show(a);
        StdOut.println(mincost1(a));
        StdOut.println(mincost2(a));
    }
}
/*
7  7  3  1  4
8  4  3  6  9
1  1  8  4  3
7  6  3  3  3
4  7  5  6  6
8  5  3  5  7
1  5  1  7  9
2  4  8  8  3

cur = 1
 2  1
10  1
 2  1

 */
// %LyW:,)a56Q-
