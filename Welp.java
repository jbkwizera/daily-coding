import java.util.ArrayList;
import java.util.HashMap;

public class Welp {
    public static void map(HashMap<Integer, char[]> hm, int[] a, ArrayList<String> res, String tem, int i) {
        if (tem.length() == a.length) {
            res.add(tem);
            return;
        }
        for (char ch: hm.get(a[i]))
            map(hm, a, res, tem + ch, i+1);
    }
    public static ArrayList<String> map(HashMap<Integer, char[]> hm, int[] a) {
        ArrayList<String> res = new ArrayList<String>();
        map(hm, a, res, "", 0);
        return res;
    }
    public static void main(String[] args) {
        HashMap<Integer, char[]> hm;
        hm = new HashMap<Integer, char[]>();

        hm.put(2, new char[]{'a', 'b', 'c'});
        hm.put(3, new char[]{'d', 'e', 'f'});
        hm.put(4, new char[]{'g', 'h', 'i'});

        int[] a = {2, 3};
        ArrayList<String> res = map(hm, a);
        for (String s: res)
            StdOut.println(s);
    }
}
