import java.util.HashMap;
import java.util.Stack;
public class BFSPathFinder {
    private HashMap<String, Integer> dist;
    private HashMap<String, String> paths;

    public BFSPathFinder(Graph G, String s) {
        dist = new HashMap<String, Integer>();
        paths = new HashMap<String, String>();
        Queue<String> q = new Queue<String>();
        q.enqueue(s);
        dist.put(s, 0);
        while (!q.isEmpty()) {
            String v = q.dequeue();
            for (String w: G.adjacentTo(v)) {
                if (!dist.containsKey(w)) {
                    dist.put(w, dist.get(v) + 1);
                    paths.put(w, v);
                    q.enqueue(w);
                }
            }
        }
    }
    public int distanceTo(String v)
    {   return dist.get(v); }
    public Iterable<String> pathTo(String v) {
        Stack<String> path = new Stack<String>();
        while (v != null && dist.containsKey(v)) {
            path.push(v);
            v = paths.get(v);
        }
        return path;
    }
    public static void main(String[] args) {
        String filename = args[0];
        String delimiter= args[1];
        Graph G = new Graph(filename, delimiter);
        String s = args[2];
        BFSPathFinder pf = new BFSPathFinder(G, s);
        while (StdIn.hasNextLine()) {
            String t = StdIn.readLine();
            int d = pf.distanceTo(t);
            for (String v: pf.pathTo(t))
                StdOut.println("    " + v);
            StdOut.println("distance: " + d);
        }
    }
}
