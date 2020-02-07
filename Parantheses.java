import java.util.Stack;
public class Parantheses {
    public static boolean match(char x, char y) {
        return x == '(' && y == ')' ||
               x == '[' && y == ']' ||
               x == '{' && y == '}';
    }
    public static boolean balanced(String s) {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')' || ch == ']' || ch == '}') {
                if (st.empty() || !match(st.pop(), ch)) return false;
            }
            else st.push(ch);
        }
        return st.empty();
    }
    public static void main(String[] args) {
        String s = "([])[]({})";
        String t = "([)]";
        String u = "((()";
        StdOut.println(balanced(s));
        StdOut.println(balanced(t));
        StdOut.println(balanced(u));
    }
}
