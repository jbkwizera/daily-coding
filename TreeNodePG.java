import java.util.HashMap;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode riht;
    public TreeNode(int x) {
        val = x;
        left = riht = null;
    }
}
public class TreeNodePG {
    private static int i = 0;
    private static HashMap<Integer, Integer> hm;
    public static TreeNode build(int[] pre, int[] in, int lo, int hi) {
        if (lo > hi) return null;
        TreeNode parent = new TreeNode(pre[i++]);
        if (lo == hi) return parent;

        int j = hm.get(parent.val);
        parent.left  = build(pre, in, lo, j-1);
        parent.riht = build(pre, in, j+1, hi);
        return parent;
    }
    public static void _inorder(TreeNode t) {
        if (t == null) return;
        _inorder(t.left);
        StdOut.print(t.val + " ");
        _inorder(t.riht);
    }
    public static void _preorder(TreeNode t) {
        if (t == null) return;
        StdOut.print(t.val + " ");
        _preorder(t.left);
        _preorder(t.riht);
    }
    public static void _postorder(TreeNode t) {
        if (t == null) return;
        _postorder(t.left);
        _postorder(t.riht);
        StdOut.print(t.val + " ");
    }
    public static void inorder(TreeNode t)
    {   _inorder(t); StdOut.println(); }
    public static void preorder(TreeNode t)
    {   _preorder(t); StdOut.println(); }
    public static void postorder(TreeNode t)
    {   _postorder(t); StdOut.println(); }

    public static TreeNode insert(TreeNode x, int v) {
        if (x == null) return new TreeNode(v);
        if (v < x.val) x.left = insert(x.left, v);
        else x.riht = insert(x.riht, v);
        return x;
    }
    static int count = 0;
    public static TreeNode kThLargest(TreeNode x, int k) {
        if (x == null || count >= k) return null;
        TreeNode r = kThLargest(x.riht, k);
        count++;
        if (count == k) return x;
        TreeNode l = kThLargest(x.left, k);
        if (r == null) return l;
        return r;
    }
    static class DeepNode {
        TreeNode val;
        int lev;
        DeepNode(TreeNode x, int N)
        {   val = x; lev = N; }
    }
    public static DeepNode deepestUtil(TreeNode x) {
        if (x == null) return new DeepNode(x, 0);
        DeepNode left = deepestUtil(x.left);
        DeepNode riht = deepestUtil(x.riht);
        DeepNode best = left;
        if (left.lev < riht.lev)
            best = riht;
        ++best.lev;
        if (best.val == null) best.val = x;
        return best;
    }
    public static TreeNode deepest(TreeNode x) {
        if (x == null || (x.left == null && x.riht == null)) return x;
        if (x.left == null) return deepest(x.riht);
        if (x.riht == null) return deepest(x.left);
        if (height(x.left) > height(x.riht)) return deepest(x.left);
        return deepest(x.riht);
    }

    public static int height(TreeNode x) {
        if (x == null) return 0;
        return 1 + Math.max(height(x.left), height(x.riht));
    }

    public static TreeNode find(TreeNode x, TreeNode res, int lev, int max) {
        if (x == null) return res;
        TreeNode left = find(x.left, res, lev+1, max);
        if (lev > max) {
            res = left;
            max = lev;
        }
        TreeNode riht = find(x.riht, res, lev, max);
        return res;
    }
    public static TreeNode find(TreeNode x) {
        return find(x, null, 0, -1);
    }
    public static TreeNode random(int N, int mx, int mn) {
        TreeNode x = null;
        for (int i = 0; i < N; i++)
            x = insert(x, StdRandom.uniform(mx, mn));
        return x;
    }
    
    public static void main(String[] args) {
        TreeNode x = new TreeNode(13);
        x.left = new TreeNode(4);
        x.left.left = new TreeNode(1);
        x.left.left.riht = new TreeNode(2);
        x.left.riht = new TreeNode(10);
        x.left.riht.left = new TreeNode(9);

        x.riht = new TreeNode(14);

    }
}
