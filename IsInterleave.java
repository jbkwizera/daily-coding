import java.util.HashSet;
import java.util.Set;
public class IsInterleave {
    public static boolean dynamic(char[] s, char[] t, char[] z) {
        int m = s.length;
        int n = t.length;
        boolean[][] IL = new boolean[m+1][n+1];

        IL[0][0] = true;
        for (int i = 1; i <= m && IL[i-1][0]; i++) // t is empty
            IL[i][0] = s[i-1] == z[i-1]; // s determines the result

        for (int j = 1; j <= n && IL[0][j-1]; j++) // s is empty
            IL[0][j] = t[j-1] == z[j-1]; // t determines the result

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                IL[i][j] = (IL[i-1][j] && s[i-1] == z[i+j-1]) ||    // t or s.
                           (IL[i][j-1] && t[j-1] == z[i+j-1]);
        return IL[m][n];
    }
    public static boolean dynamic(char[] s, char[] t, char[] z, int i, int j, int k, int[][] IL) {
        if (i == s.length && j == t.length) return true;
        if (IL[i][j] != 0) return IL[i][j] == 1; // was the visit successful?

        if ((i < s.length && s[i] == z[k] && dynamic(s, t, z, i+1, j, i+j+1, IL)) ||
            (j < t.length && t[j] == z[k] && dynamic(s, t, z, i, j+1, i+j+1, IL)))
            IL[i][j] = 1;   // the visit is successful
        else IL[i][j]= -1;  // the visit is unsuccessful
        return IL[i][j] == 1;  // ultimate visit.
    }
    public static boolean notnaive(String s, String t, String z, int i, int j, int k, Set<Integer> memo) {
        if (i == s.length()) return t.substring(j).equals(z.substring(k));
        if (j == t.length()) return s.substring(i).equals(z.substring(k));
        int hash = (i << 16) | j;
        if (memo.contains(hash)) return false;

        if (s.charAt(i) == z.charAt(k) && notnaive(s, t, z, i+1, j, i+j+1, memo)) return true;
        if (t.charAt(j) == z.charAt(k) && notnaive(s, t, z, i, j+1, i+j+1, memo)) return true;
        memo.add(hash);
        return false;
    }
    public static void main(String[] args) {
        String s = args[0];
        String t = args[1];
        String z = args[2];

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        char[] c = z.toCharArray();

        StdOut.println("dynamic1: " + dynamic(a, b, c));
        StdOut.println("dynamic2: " + dynamic(a, b, c, 0, 0, 0, new int[a.length+1][b.length+1]));
        StdOut.println("notnaive: " + notnaive(s,t, z, 0, 0, 0, new HashSet<Integer>()));
    }
}
