public class Unival {
    private Node root;
    private class Node {
        int val;
        Node left;
        Node riht;
        private Node(int val) { this.val = val; }
    }
    public Unival()
    {   initialize(); }
    private void initialize() {
        Node x = new Node(0);
        Node y = new Node(1);
        root   = new Node(0);
        root.left = y;
        root.riht = x;

        y.left = y;
        y.riht = y;
        root.riht.left = y;
        root.riht.riht = x;
    }
    public int countsubt()
    {   return countsubt(root); }

    public int countsubt(Node x) {
        if (x == null) return 0;
        if (x.left == null && x.riht == null)
            return 1;
        if (x.left == null)
            return 1 + countsubt(x.riht);
        if (x.riht == null)
            return 1 + countsubt(x.left);
        return countsubt(x.left) + countsubt(x.riht);
    }
    public static void main(String[] args) {
        Unival un = new Unival();
        StdOut.println(un.countsubt());
    }
}
