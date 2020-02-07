import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFiles {
    public static void work(String files, String pad) {
        if (files.indexOf(".") >= 0) {
            StdOut.println(files);
            return;
        }
    }
    public static void main(String[] args) throws IOException {
        String s = StdIn.readAll();

        String pad = "\\n\\t";
        String[] t = s.split(pad+"^[\\]");
        for (String re: t)
            StdOut.println(re);
    }
}
