public class Kadane {
    public static int max(int[] a) {
        int cur = 0;
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            cur = Math.max(cur + a[i], a[i]);
            max = Math.max(cur, max);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();
        StdOut.println(max(a));
    }
}
