class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
        val  = x;
        next = null;
    }
}
public class ListNodePG {
    public static int size(ListNode head) {
        if (head == null) return 0;
        int i = 0;
        for (ListNode x = head; x != null; x = x.next)
            i++;
        return i;
    }
    public static String value(ListNode head) {
        String s = "";
        for (ListNode x = head; x != null; x = x.next)
            s += x.val + " ";
        return s;
    }
    public static ListNode pushBack(ListNode tail, int x) {
        ListNode oldTail = tail;
        tail = new ListNode(x);
        oldTail.next = tail;
        return tail;
    }
    public static ListNode combine(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        ListNode res = new ListNode(0);
        ListNode end = res;
        while (a != null || b != null) {
            if      (a == null) { end = pushBack(end, b.val); b = b.next; }
            else if (b == null) { end = pushBack(end, a.val); a = a.next; }
            else                { end = pushBack(end, a.val); a = a.next; }
        }
        return res.next;
    }
    public static ListNode getMiddle(ListNode head) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static ListNode merge(ListNode a, ListNode b) {
		if (a == null) return b;
		if (b == null) return a;
        ListNode res = null;
		if (a.val > b.val) {
			res = b;
			res.next = merge(a, b.next);
		}
        else {
			res = a;
			res.next = merge(a.next, b);
		}
		return res;
	}
    public static ListNode sort(ListNode a) {
        if (a == null || a.next == null)
            return a;

        ListNode oldHead = a;
		int mid = size(a)/2;
		while (mid - 1 > 0) {
			oldHead = oldHead.next;
			mid--;
		}
		ListNode newHead = oldHead.next;

		oldHead.next = null;
		oldHead = a;
		ListNode left = sort(oldHead);
		ListNode riht = sort(newHead);
		return merge(left, riht);
    }
    public static ListNode random(int N, int min, int max) {
        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < N; i++) {
            int r = StdRandom.uniform(min, max);
            if (tail != null) tail = pushBack(tail, r);
            else {
                tail = new ListNode(r);
                head = tail;
            }
        }
        return head;
    }
    public static void deleteKthLast(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; fast != null && i < k; i++)
            fast = fast.next;
        if (fast == null)
        {   head = head.next; return; }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
    }
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        StdRandom.setSeed(20);
        ListNode list = random(N, 0, 20);

        StdOut.println(value(list));
        deleteKthLast(list, k);
        StdOut.println(value(list));
    }
}
