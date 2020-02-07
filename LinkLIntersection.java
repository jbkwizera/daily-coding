public class LinkLIntersection {
    private Node first;
    private Node last;
    private int N;
    private class Node {
        private int val;
        private Node next;
    }
    public void add(int x) {
        Node temp = new Node();
        temp.val = x;
        if (N == 0) { first = temp; last = temp; }
        else {
            Node oldLast = last;
            last = temp;
            oldLast.next = last;
        }
        N++;
    }
    public void show() {
        for (Node x = first; x != null; x = x.next)
            StdOut.printf("%2d ", x.val);
        StdOut.println();
    }
    public void reverse() {
        Node reverse = null;
        while (first != null) {
            Node second = first.next;
            first.next  = reverse;
            reverse     = first;
            first       = second;
        }
        first = reverse;
        last  = first;
        while (last.next != null) last = last.next;
    }
    public int intersection(LinkLIntersection that) {
        int  v = first.val;
        for (Node x = this.first, y = that.first;
                x != null && y != null && x.val == y.val; x = x.next, y = y.next)
            v = x.val;
        return v;
    }
    public static void main(String[] args) {
        LinkLIntersection x = new LinkLIntersection();
        LinkLIntersection y = new LinkLIntersection();

        x.add(3); x.add(7); x.add(8); x.add(10);
        y.add(99); y.add(1); y.add(8); y.add(10);
        x.show();
        y.show();
        StdOut.println("----------------");
        x.reverse();
        y.reverse();
        x.show();
        y.show();
        StdOut.println("----------------");
        StdOut.println(y.intersection(x));
    }
}
