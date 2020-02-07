public class Fdecode {
    public static int count(String s) {
        if (s.length() == 0)
            return 1;
        if (s.startsWith("0"))
            return 0;
        int x = 0;
        if (s.length() >= 2)
            x = Integer.parseInt(s.substring(0, 2));
        if (x >= 1 && x <= 26)
            return count(s.substring(1)) + count(s.substring(2));
        return count(s.substring(1));
    }
    public static void main(String[] args) {
        String s = args[0];
        StdOut.println(count(s));
    }
}
