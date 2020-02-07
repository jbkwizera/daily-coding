public class WordSearchGrid {
    private static int M, N, L;
    public static boolean search(char[][] a, char[] s, int i, int j, int k) {
        if (k == L) return true;
        if (i == M || j == N) return false;

        if (a[i][j] == s[k])
             return search(a, s, i+1, j, k+1) || search(a, s, i, j+1, k+1);
        else return search(a, s, i+1, j, 0)   || search(a, s, i, j+1, 0);
    }
    public static boolean search(char[][] a, char[] s) {
        M = a.length;
        N = a[0].length;
        L = s.length;
        return search(a, s, 0, 0, 0);
    }
    public static boolean dynamic(char[][] a, char[] s) {
        M = a.length;
        N = a[0].length;
        int[][] dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0) {
                    if (a[i][j] == s[0])
                        dp[i][j] = 1;
                }
                else if (i == 0) {
                    if (a[i][j] == s[dp[i][j-1]])
                        dp[i][j] = dp[i][j-1] +1;
                }
                else if (j == 0) {
                    if (a[i][j] == s[dp[i-1][j]])
                        dp[i][j] = dp[i-1][j] +1;
                }
                else {
                    if (a[i][j] == s[dp[i-1][j]])
                        dp[i][j] = dp[i-1][j] +1;
                    if (a[i][j] == s[dp[i][j-1]])
                        dp[i][j] = dp[i][j-1] +1;
                }
                if (dp[i][j] == s.length)
                    return true;
            }
        }
        return false;
    }
    public static void show(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++)
                StdOut.printf("%2d ", a[i][j]);
            StdOut.println();
        }
    }
    public static void main(String[] args) {
        char[][] a = {
            {'F', 'A', 'C', 'I', 'L', 'E'},
            {'O', 'B', 'Q', 'P', 'D', 'M'},
            {'A', 'N', 'O', 'B', 'D', 'C'},
            {'M', 'A', 'S', 'S', 'K', 'N'}
        };
        char[] s = args[0].toCharArray();
        StdOut.println(search(a, s));
        StdOut.println(dynamic(a, s));
    }
}
