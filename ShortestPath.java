import java.util.ArrayList;
import java.util.Collections;

public class ShortestPath {
    private static ArrayList<Integer> aList = new ArrayList<Integer>();
    public static void path(int[][] a, int[][] sol, int i, int j, int count) {
        int M = a.length;
        int N = a[0].length;

        if (sol[i][j] != 0 || a[i][j] != 0) return;
        sol[i][j] = count;
        if (i == M-1 && j == N-1)
        {   aList.add(count); }

        if (i-1 >= 0 && a[i-1][j] == 0) path(a, sol, i-1, j, count+1);
        if (i+1 <  M && a[i+1][j] == 0) path(a, sol, i+1, j, count+1);
        if (j-1 >= 0 && a[i][j-1] == 0) path(a, sol, i, j-1, count+1);
        if (j+1 <  N && a[i][j+1] == 0) path(a, sol, i, j+1, count+1);
        sol[i][j] = 0;
    }
    // dynamic
    public static void path(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int[][] sol = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (a[i][j] == 0) sol[i][j] = 1;
                else              sol[i][j] = 0;

        //
        /*
        1 1 1 1
        0 0 1 0
        1 1 1 1
        1 1 1 1

        */

    }
    public static void show(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++)
                StdOut.printf("%2d ", a[i][j]);
            StdOut.println();
        }
        StdOut.println("--------------");
    }
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int[][] a = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (StdRandom.uniform(0.0, 1.0) < 0.3)
                    a[i][j] = 1;

        show(a);
        path(a, new int[N][N], 0, 0, 1);
        StdOut.println(aList.size());
    }
}
