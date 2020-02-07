import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;

public class LinkedHashMapLRU<Key, Value> {
    private LinkedHashMap<Key, Value> lhm;
    private final int CAPACITY;

    public LinkedHashMapLRU(int cap) {
        CAPACITY = cap;
        lhm = new LinkedHashMap<Key, Value>(cap) {
            protected boolean removeEldestEntry(Map.Entry<Key, Value> eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public Value get(Key key) {
        if (lhm.containsKey(key)) {
            Value val = lhm.get(key);
            lhm.remove(key);
            lhm.put(key, val);
            return val;
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (lhm.containsKey(key))
            lhm.remove(key);
        lhm.put(key, val);
    }
    protected boolean removeEldestEntry(Map.Entry<Key, Value> eldest) {
        return lhm.size() > CAPACITY;
    }
    public String toString() {
        String s = "";
        for (Key key: lhm.keySet())
            s += lhm.get(key) + " ";
        return s.trim();
    }
    public static void main(String[] args) {

    }
}
