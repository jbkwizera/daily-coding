import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;

class Node {
    String value;
    Node left;
    Node right;
    Node(String value, Node left, Node right) {
        this.value = value;
        this.left  = left;
        this.right = right;
    }
}

public class BTreeSerialization {
    public static HashMap<Integer, String> serialize(Node root) {
        if (root == null) return null;

        // Hashmap to hold indices of the btree values in a complete btree
        HashMap<Integer, String> hm;
        hm = new HashMap<Integer, String>();
        hm.put(0, root.value);

        // Traverse the tree level-order/top-bottom, left-right and keep
        // track of the level-order indices of the btree values
        Queue<Integer> id = new LinkedList<Integer>();
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        id.add(0);
        while (!q.isEmpty()) {
            int i = id.remove();
            Node x = q.remove();
            if (x.left  != null) {
                q.add(x.left);
                id.add(i*2 + 1);
                if (x.left.value != null)
                    hm.put(i*2 + 1, x.left.value);
            }
            if (x.right != null) {
                q.add(x.right);
                id.add(i*2 + 2);
                if (x.right.value != null)
                    hm.put(i*2 + 2, x.right.value);
            }
        }
        return hm;
    }

    public static Node deserialize(HashMap<Integer, String> hm)
    {   return buildBTree(hm, 0);   }

    public static Node buildBTree(HashMap<Integer, String> hm, int i) {
        // Recursively build a tree from the hashmap level-order index-value mapping
        if (hm.get(i) == null) return null;
        Node x  = new Node(hm.get(i), null, null);
        x.left  = buildBTree(hm, 2*i + 1);
        x.right = buildBTree(hm, 2*i + 2);
        return x;
    }
    
    public static boolean equals(Node x, Node t) {
        if (x == null && t != null) return false;
        if (x != null && t == null) return false;
        if (x == null && t == null) return true;
        return x.value.equals(t.value) && equals(x.left, t.left) && equals(x.right, t.right);
    }

    public static void main(String[] args) {
        
        Node f = new Node("f", new Node("j", new Node("n", null, null), null), null);
        Node e = new Node("e", new Node("h", null, null), new Node("i", new Node("m", null, null), null));
        Node d = new Node("d", null, new Node("g", new Node("k", null, null), new Node("l", null, null)));
        
        Node a = new Node("a", new Node("b", d, null), new Node("c", e, f));

        HashMap<Integer, String> hm = serialize(a);
        Node r = deserialize(hm);
        if (!equals(a, r))
            System.out.println("Deserialization of serialization not equal to the orig. tree");
        System.out.println(hm);
    }
}
