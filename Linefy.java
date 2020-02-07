public class Linefy {
    public static void eval(String s, int k) {
        s = s.trim();
        if (s.length() < k) {
            StdOut.println(s);
            return;
        }
        int i = k;
        while (i >= 0 && s.charAt(i) != ' ') i--;
        StdOut.println(s.substring(0, i));
        eval(s.substring(i), k);
    }
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        String s = StdIn.readAll();

        eval(s, k);
    }
}
