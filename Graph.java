import java.util.HashMap;
import java.util.HashSet;
public class Graph {
    private HashMap<String, HashSet<String>> hm;

    public Graph()
    {   hm = new HashMap<String, HashSet<String>>(); }

    public Graph(String filename, String delimiter) {
        hm = new HashMap<String, HashSet<String>>();
        In in = new In(filename);
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] fields = line.split(delimiter);
            for (int i = 1; i < fields.length; i++)
                addEdge(fields[0], fields[i]);
        }
    }
    public void addEdge(String u, String v) {
        if (!hm.containsKey(u)) hm.put(u, new HashSet<String>());
        if (!hm.containsKey(v)) hm.put(v, new HashSet<String>());
        hm.get(u).add(v);
        hm.get(v).add(u);
    }
    public Iterable<String> adjacentTo(String v)
    {   return hm.get(v);   }
    public Iterable<String> vertices()
    {   return hm.keySet(); }

    public int V()
    {   return hm.size(); }
    public int E()
    {   return 0; }

    public int degree(String v)
    {   return hm.get(v).size(); }

    public boolean hasVertex(String v)
    {   return hm.containsKey(v); }
    public boolean hasEdge(String u, String v)
    {   return hm.containsKey(u) && hm.get(u).contains(v); }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (String v: vertices()) {
            s.append(v + " ");
            for (String u: adjacentTo(v))
                s.append(u + " ");
            s.append("\n");
        }
        return new String(s);
    }
    public static void main(String[] args) {
        String filename = args[0];
        String delimiter= args[1];
        Graph G = new Graph(filename, delimiter);

        while (StdIn.hasNextLine()) {
            String v = StdIn.readLine();
            for (String u: G.adjacentTo(v))
                StdOut.println("   " + u);
        }
    }
}
