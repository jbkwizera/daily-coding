import java.util.*;
class TreeNode {
    String item;
    TreeNode left;
    TreeNode riht;
    public TreeNode(String x)
    {   item = x; left = null; riht = null; }
}
public class PrefixTree {
    public static String parseTree(TreeNode x) {
        if (x == null) return "";
        String opt = x.item + " ";
        String left = parseTree(x.left);
        String riht = parseTree(x.riht);
        return opt + left + riht;
    }
    public static double evaluate(String s) {
        String[] terms = s.split("\\s+");
        Stack<String> exp = new Stack<String>();
        Stack<Double> res = new Stack<Double>();
        for (String term: terms) exp.push(term);

        while (!exp.isEmpty()) {
            String term = "";
            while (true) {
                term = exp.pop();
                if (isOperator(term)) break;
                res.push(Double.parseDouble(term));
            }
            if      (term.equals("*")) res.push(res.pop()*res.pop());
            else if (term.equals("+")) res.push(res.pop()+res.pop());
            else if (term.equals("-")) res.push(res.pop()-res.pop());
            else if (term.equals("/")) res.push(res.pop()/res.pop());
        }
        return res.pop();
    }
    public static boolean isOperator(String s) {
        return "-+/*".indexOf(s) >= 0;
    }
    public static void main(String[] args) {
        TreeNode tree = new TreeNode("-");
        tree.left = new TreeNode("*");
        tree.left.left = new TreeNode("+");
        tree.left.left.left = new TreeNode("14");
        tree.left.left.riht = new TreeNode("07");
        tree.left.riht = new TreeNode("03");

        tree.riht = new TreeNode("*");
        tree.riht.left = new TreeNode("-");
        tree.riht.left.left = new TreeNode("02");
        tree.riht.left.riht = new TreeNode("08");
        tree.riht.riht = new TreeNode("+");
        tree.riht.riht.left = new TreeNode("09");
        tree.riht.riht.riht = new TreeNode("11");

        // the expression.
        int val = (((14 + 7) * 3) - ((2 - 8) * (9 + 11)));

        String expression = parseTree(tree);
        StdOut.println(expression);
        StdOut.println(evaluate(expression));
    }
}
