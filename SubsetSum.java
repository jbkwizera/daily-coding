import java.util.*;
public class SubsetSum {
    private static List<ArrayList<Integer>> solutions;
    public static void subs(ArrayList<Integer> curSubset, int[] a, int sum, int i) {
        if (sum == 0) solutions.add(curSubset);
        if (i == a.length) return;
        subs(curSubset, a, sum, i+1);
        if (sum >= a[i]) {
            ArrayList<Integer> temp = new ArrayList<Integer>(curSubset);
            temp.add(a[i]);
            subs(temp, a, sum-a[i], i+1);
        }
    }
    public static boolean dynamic(int[] a, int sum) {
        int N = a.length;
        boolean[][] isSum = new boolean[sum+1][N+1];
        for (int j = 0; j <= N; j++)
            isSum[0][j] = true; // since every subset has an empty set.

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= N; j++) {
                if (i >= a[j-1]) isSum[i][j] = isSum[i][j-1] || isSum[i-a[j-1]][j-1];
                else isSum[i][j] = isSum[i][j-1];
            }
        }
        return isSum[sum][N];
    }
    public static void main(String[] args) {
        int[] a = {3, 1, 1, 7};
        int sum = 9;
        StdOut.println(dynamic(a, sum));
    }
}
