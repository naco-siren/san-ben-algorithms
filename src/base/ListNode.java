package base;

/**
 * Created by naco_siren on 8/21/17.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) { val = x; }

    @Override
    public String toString() {
        return String.valueOf(val);
    }


    public static ListNode generateLinkedList(int[] vals) {
        ListNode sentinel = new ListNode(-1);
        ListNode tail = sentinel;
        for (int val : vals) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        return sentinel.next;
    }

    public static boolean linkedListEquals(int[] expected, ListNode head) {
        ListNode iter = head;
        for (int val : expected) {
            if (iter == null)
                return false;

            if (iter.val != val)
                return false;

            iter = iter.next;
        }
        return iter == null;
    }
}
