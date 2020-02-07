public class UnionFind {
    private int[] id; // id of an object
    private int[] sz; // size of a component with id = i-th index
    private int components;
    public UnionFind(int N) {
        id = new int[N];
        sz = new int[N];
        components = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }
    public int count() {
        return components;
    }
    public boolean connected(int u, int v) {
        return find(u) == find(v);
    }
    public void union(int u, int v) {
        int i = find(u);
        int j = find(v);
        // u and v are already connected.
        if (i == j) return;

        // hang the smaller comp. to the bigger comp.
        if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        else               { id[j] = i; sz[i] += sz[j]; }
        components--;
    }
    public int find(int p) {
        // chase links up the tree to the root.
        while (p != id[p]) p = id[p];
        return p;
    }
    public static void main(String[] args) {
        // K sets of M length

        int[][] a = {
            {0, 1, 2},
            {3, 4},
            {2, 3, 4},
            {5, 6}
        };

        // UnionFind with 7 objects
        UnionFind uf = new UnionFind(7);

        // build uf: takes O(MK)
        for (int i = 0; i < a.length; i++)
            for (int j = 1; j < a[i].length; j++)
                uf.union(a[i][j], a[i][j-1]);

        // disconnected components
        System.out.println(uf.count());
    }
}
