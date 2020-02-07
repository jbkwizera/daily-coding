import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFU<Key, Value> {
    private HashMap<Key, Value> kvMap;
    private HashMap<Key, Integer> kfMap;
    private HashMap<Integer, LinkedHashSet<Key>> order;
    private int CAP;
    private int min;

    public LFU(int capacity) {
        CAP = capacity;
        kvMap = new HashMap<Key, Value>();
        kfMap = new HashMap<Key, Integer>();
        order = new HashMap<Integer, LinkedHashSet<Key>>();
        order.put(1, new LinkedHashSet<Key>());
    }
    public void put(Key key, Value val) {
        if (kvMap.containsKey(key)) {
            kvMap.put(key, val);
            get(key);
            return;
        }
        if (kvMap.size() == CAP) {
            Key temp = order.get(min).iterator().next();
            order.get(min).remove(temp);
            kvMap.remove(temp);
            kfMap.remove(temp);
        }
        kvMap.put(key, val);
        kfMap.put(key, 1);
        order.get(1).add(key);
        min = 1;
    }
    public void get()
    public static void main(String[] args) {
    }
}
