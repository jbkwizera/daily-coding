public class DutchFlagRGB {
    public static void exch(char[] a, int i, int j)
    {   char t = a[i]; a[i] = a[j]; a[j] = t; }

    public static void main(String[] args) {
        char[] a = {'G', 'B', 'R', 'R', 'B', 'R', 'G', 'G', 'B', 'R', 'R', 'B'};
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();

        int lt = 0;
        int gt = a.length-1;
        int i  = 0;

        while (i <= gt) {
            if      (a[i] == 'R') exch(a, i++, lt++);
            else if (a[i] == 'B') exch(a, i, gt--);
            else    i++;
        }
        for (i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
}
