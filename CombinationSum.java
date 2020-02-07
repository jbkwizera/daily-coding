import java.util.*;
public class CombinationSum {

    private static void combSum(int[] a, List<List<Integer>> res, List<Integer> cur, int T, int k) {
        if (T == 0)
        { res.add(new ArrayList<Integer>(cur)); return; }
        for (int i = k; i < a.length; i++) {
            if (T-a[i] >= 0) {
                cur.add(a[i]);
                combSum(a, res, cur, T-a[i], i);
                cur.remove(cur.size()-1);
            }
        }
    }
    public static List<List<Integer>> combSum(int[] a, int T) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<Integer>();
        combSum(a, res, cur, T, 0);
        return res;
    }
    public static void main(String[] args) {
        int[] a = {1, 1, 1};
        int T = Integer.parseInt(args[0]);
        StdOut.println(((T+1)*(T+2))/2 + " - " + combSum(a, T).size());
    }
}
