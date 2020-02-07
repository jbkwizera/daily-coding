import java.util.NoSuchElementException;
public class DoubleNode<Item> {
    private Node head;
    private Node tail;
    private int N;

    private class Node {
        Item item;
        Node prev;
        Node next;
        Node(Item item)
        { this.item = item; }
    }
    public DoubleNode() {
        head = new Node(null);
        tail = new Node(null);
        head.next = tail;
        tail.prev = head;
    }
    public int size()
    {   return N; }
    public boolean isEmpty()
    {   return N == 0; }

    public void pushFront(Item item) {
        Node x = new Node(item);
        x.prev = head;
        x.next = head.next;
        head.next.prev = x;
        head.next = x;
        N++;
    }
    public void pushBack(Item item) {
        Node x = new Node(item);
        x.next = tail;
        x.prev = tail.prev;
        tail.prev.next = x;
        tail.prev = x;
        N++;
    }
    public Item deleteNode(Node x) {
        if (N == 0)
            throw new NoSuchElementException("list is empty.");
        Item item   = x.item;
        x.prev.next = x.next;
        x.next.prev = x.prev;
        N--;
        return item;
    }
    public Item popFront() {
        return deleteNode(head.next);
    }
    public Item popBack() {
        return deleteNode(tail.prev);
    }
    public String toString() {
        String s = "";
        for (Node x = head.next; x.next != null; x = x.next)
            s += "-->" + x.item;
        return s;
    }
    public static void main(String[] args) {
        DoubleNode<Integer> dlist = new DoubleNode<Integer>();

        dlist.pushFront(1);
        dlist.pushFront(2);
        dlist.pushFront(3);
        System.out.println(dlist);

        dlist.pushBack(1);
        dlist.pushBack(2);
        dlist.pushBack(3);
        System.out.println(dlist);

        while (dlist.size() != 1)
            dlist.popBack();
    }
}
