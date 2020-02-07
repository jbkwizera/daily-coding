import java.util.HashMap;
public class LRU {
    private class Node {
        int key;
        int val;
        Node next;
        Node prev;
        Node(int x, int v) {
            key = x;
            val = v;
        }
    }
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> hm;
    private final int CAPACITY;

    public LRU(int cap) {
        hm = new HashMap<Integer, Node>(cap);
        CAPACITY = cap;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    public int get(Integer key) {
        if (hm.containsKey(key)) {
            Node toMove = hm.get(key);  // save the node
            hm.remove(key);             // remove it from hm.
            remove(toMove);             // remove it from list
            pushFront(toMove);          // move it to the front
            hm.put(key, toMove);        // put it back in hm
            return hm.get(key).val;     // return the value
        }
        return -1;
    }
    public void put(Integer key, Integer val) {
        if (hm.containsKey(key)) {
            Node toMove = hm.get(key);
            hm.remove(key);             // remove from hm
            remove(toMove);             // remove from list
            toMove.val = val;           // modify the value
            pushFront(toMove);          // push to the front
            hm.put(key, toMove);        // put it back in hm
            return;
        }
        if (hm.size() == CAPACITY) {
            StdOut.println("rem: " + tail.prev.val);
            hm.remove(tail.prev.key);   // remove lru item from hm.
            popBack();                  // remove lru item from list
        }
        pushFront(new Node(key, val));  // push to the front
        hm.put(key, head.next);         // put the entry in hm.
    }

    /**************** PRIVATE UTILITY METHODS ***********************/
    private void remove(Node x) {
        x.next.prev = x.prev;
        x.prev.next = x.next;
    }
    private void pushFront(Node x) {
        x.prev = head;
        x.next = head.next;
        head.next.prev = x;
        head.next = x;
    }
    private void popFront() {
        remove(head.next);
    }
    private void popBack() {
        remove(tail.prev);
    }
    public String toString() {
        String s = "";
        for (Node x = head.next; x.next != null; x = x.next)
            s += x.val + "-->";
        return s;
    }
    public static void main(String[] args) {
        int N = 2;
        LRU cache = new LRU(N);

        cache.put(1, 1);
        StdOut.println(cache);
        cache.put(2, 2);
        StdOut.println(cache);
        StdOut.println(cache.get(1));
        StdOut.println(cache);
        cache.put(3, 3);
        StdOut.println(cache);
        StdOut.println(cache.get(1));
        StdOut.println(cache);
        cache.put(4, 4);
        StdOut.println(cache);
        StdOut.println(cache.get(1));
        StdOut.println(cache);
        StdOut.println(cache.get(3));
        StdOut.println(cache);
        StdOut.println(cache.get(4));
        StdOut.println(cache);
    }
}
//[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
