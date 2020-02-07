public class EditDistance {
    public static int cost1(char[] s, char[] t, int i, int j) {
        if (i == s.length) return t.length-j;
        if (j == t.length) return s.length-i;

        if (s[i] == t[j]) return cost1(s, t, i+1, j+1);
        return 1 + min(cost1(s, t, i+1, j+1), cost1(s, t, i+1, j), cost1(s, t, i, j+1));
    }
    public static int cost1(char[] s, char[] t)
    {   return cost1(s, t, 0, 0); }
    private static int min(int x, int y, int z)
    {   return Math.min(Math.min(x, y), z); }

    public static int cost2(char[] s, char[] t) {
        int m = s.length;
        int n = t.length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if      (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;  // min ops at i
                else if (s[i-1] == t[j-1])
                    dp[i][j] = dp[i-1][j-1];    // just what it costed the prev.
                                                // take the minimum of all costs.
                else dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]);
            }
        }
        //show(dp);
        return dp[m][n];
    }
    /*
    public static void show(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++)
                StdOut.printf("%2d ", a[i][j]);
            StdOut.println();
        }
    } */
    public static void main(String[] args) {
        char[] s = args[0].toCharArray();
        char[] t = args[1].toCharArray();
        StdOut.println(cost1(s, t) + "-" + cost2(s, t));
    }
}
