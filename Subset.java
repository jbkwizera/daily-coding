import java.util.ArrayList;
import java.util.List;

public class Subset {
    private static List<ArrayList<Integer>> powerSet;

    public static void subs(ArrayList<Integer> curSubset, int[] a, int i) {
        if (a.length <= i) powerSet.add(curSubset);
        else {
            subs(curSubset, a, i+1);
            ArrayList<Integer> temp = new ArrayList<Integer>(curSubset);
            temp.add(a[i]);
            subs(temp, a, i+1);
        }
    }
    public static void main(String[] args) {

        int[] a = {0, 1, 2, 3, 4, 5};
        powerSet = new ArrayList<ArrayList<Integer>>();
        subs(new ArrayList<Integer>(), a, 0);

        for (ArrayList<Integer> set: powerSet)
            StdOut.println(set);
    }
}
