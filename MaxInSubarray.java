import java.util.*;
public class MaxInSubarray {
    public static void main(String[] args) {
        int k = StdIn.readInt();
        int[] a = StdIn.readAllInts();
        Deque<Integer> q = new LinkedList<Integer>();

        for (int i = 0; i < a.length; i++) {
            while (!q.isEmpty() && q.peek() <= i-k)
                q.removeFirst();
            while (!q.isEmpty() && a[q.peekLast()] <= a[i])
                q.removeLast();
            q.addLast(i);
            if (i+1 >= k) StdOut.println(a[q.peek()]);
        }
    }
}
