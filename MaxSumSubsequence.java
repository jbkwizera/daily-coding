public class MaxSumSubsequence {
    private static int max = 0;
    private static void kLength(int[] a, int prev, int sum, int j, int k) {
        if (k == 0) {
            if (sum > max) max = sum;
            return;
        }
        for (int i = j; i < a.length; i++)
            if (a[i] > prev)
                kLength(a, a[i], a[i]+sum, i+1, k-1);
    }
    public static int kLength(int[] a, int k) {
        max = 0;
        kLength(a, 0, 0, 0, k);
        return max;
    }
    private static void nLength(int[] a, int prev, int sum, int j) {
        if (j == a.length) {
            if (sum > max) max = sum;
            return;
        }
        if (a[j] > prev)
            nLength(a, a[j], a[j]+sum, j+1);
        nLength(a, prev, sum, j+1);
    }
    public static int nLength(int[] a) {
        int length = 0;
        int[] dp = new int[a.length];
        for (int j = 0; j < a.length; j++) {
            dp[j] = 1;
            for (int i = 0; i < j; i++)
                if (a[j] > a[i] && dp[i]+1 > dp[j])
                    dp[j] = dp[i]+1;
            if (dp[j] > length) length = dp[j];
        }
        return length;
    }
    public static int nSum(int[] a) {
        int sum = 0;
        int[] dp = new int[a.length];
        for (int j = 0; j < a.length; j++) {
            dp[j] = a[j];
            for (int i = 0; i < j; i++)
                if (a[j] > a[i] && dp[i]+a[j] > dp[j])
                    dp[j] = dp[i]+a[j];
            if (dp[j] > sum) sum = dp[j];
        }
        return sum;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        /*
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = i+1;
            */
        int[] a = {50, 3, 10, 7, 40, 80};
        StdOut.println(nLength(a));
        StdOut.println(nSum(a));
    }
}
/*
Thursday, November 21st, 10:00am-10:45am, 11:00am-11:45am
Tuesday,  November 26th, 01:00pm-01:45pm, 02:00pm-02:45pm
Tuesday,  November 26th, 10:00am-10:45pm, 11:00am-11:45pm
Thursday, November 28st, 10:00am-10:45am, 11:00am-11:45am
Thursday, November 28st, 01:00pm-01:45pm, 02:00pm-02:45pm */
