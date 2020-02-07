import java.util.Arrays;
public class Runlength {
    public static String encode(String s) {
        int N = s.length();
        String t = "";
        int count = 0;
        for (int i = 0; i < N; i += count) {
            char cur = s.charAt(i);
            count = 1;
            while (i+count < N && s.charAt(i+count) == cur) count++;
            t += count + "" + cur;
        }
        return t;
    }
    public static String decode(String s) {
        String[] count = s.split("[a-zA-Z]+");
        String[] alpha = s.split("[0-9]+");
        String res = "";
        for (int i = 0; i < count.length; i++)
            for (int j = 0; j < Integer.parseInt(count[i]); j++)
                res += alpha[i+1];
        return res;
    }
    public static void main(String[] args) {
        String s = args[0];
        if (args[1].equals("e"))
             StdOut.println(encode(s));
        else StdOut.println(decode(s));
    }
}
