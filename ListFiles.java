import java.util.*;
public class ListFiles {
    public static void list(String s, String pad) {
        int i = s.indexOf(pad);
        if (i < 0) {
            StdOut.println(s);
        }
        // find the first and the last index.
        else {
            StdOut.println(s.substring(0, i));
            while (i > 0 && s.charAt(i+4) != '\\') {
                list(s.substring(i+4).trim(), pad + "\\t");
                s = s.substring(i+pad.length());
                i = s.indexOf(pad);
            }
        }

    }
    public static void main(String[] args) {
        String s = StdIn.readAll();
        StdOut.println(s);
        String pad = "\\n\\t";
        list(s, pad);



        /*
        dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext
        String pad = "\\n\\t";
        String[] t = s.split(pad);
        int j = s.indexOf(pad + "\\t");
        StdOut.println(s.substring(j + pad.length()+2)); */
    }
}
