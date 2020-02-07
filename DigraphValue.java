import java.util.Arrays;
public class DigraphValue {
    public static int path(int[][] a) {
        int N = a.length;
        int val = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (a[j][0] == a[i][0]) {
                    int[] cnts = new int[26];
                    val = Math.max(val, path(a, cnts, a[j][1], 0, 0, N));
                }
            }
            StdOut.println();
        }
        return val;
    }
    public static int path(int[][] a, int[] cnts, int node, int val, int k, int N) {
        for (int i = k; i < N; i++) {
            if (a[i][0] == node) {
                StdOut.println(Arrays.toString(a[i]));
                cnts[node]++;
                val = Math.max(val, path(a, cnts, a[i][1], val, i, N));
            }
        }
        return val;
    }
    public static int max(int[] cnts) {
        int max = 0;
        for (int i = 0; i < cnts.length; i++)
            if (cnts[i] > max) max = cnts[i];
        return max;
    }
    public static int iterate(int[][] a, char[] s) {
        int N = a.length;
        int value = 0;
        for (int i = 0; i < N; i++) {
            if (a[i][0] == a[i][1]) continue;
            int[] cnts = new int[26];
            cnts[s[a[i][0]]-65]++;
            cnts[s[a[i][1]]-65]++;

            StdOut.print(a[i][0] + " " + a[i][1] + " ");
            int node = a[i][1], k = i+1;
            while (k < N && a[k][0] == node)
            {   node = a[k++][1]; cnts[s[node]-65]++; StdOut.print(node + " "); }
            value = Math.max(value, max(cnts));
            StdOut.println();
        }
        return value;
    }
    public static void main(String[] args) {
        String s = StdIn.readString();
        int N = StdIn.readInt();
        int[][] a = new int[N][2];
        for (int i = 0; i < N; i++) {
            int u = StdIn.readInt();
            int v = StdIn.readInt();
            a[i]  = new int[]{u, v};
        }

        StdOut.println("value: " + iterate(a, s.toCharArray()));
    }
}
