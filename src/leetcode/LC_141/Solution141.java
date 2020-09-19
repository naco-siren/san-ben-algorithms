package leetcode.LC_141;

import base.ListNode;

/**
 * 141. Linked List Cycle
 */
public class Solution141 {

    /*
     * Smart approach: fast pointer starts from `head`'s next
     */
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null)      // NO NEED TO CHECK FOR `slow`'s null, because `fast` is always ahead
                return false;

            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /*
     * Naive approach: both pointers start from `head`
     */
    public boolean hasCycle2(ListNode head) {
        ListNode fast = head, slow = head;

        while (true) {              // Cannot use `slow != fast` condition check

            if (slow == null)       // and have null check every time, BAD!
                return false;
            slow = slow.next;

            if (fast == null)       // ditto
                return false;
            fast = fast.next;

            if (fast == null)       // ditto
                return false;
            fast = fast.next;

            if (slow == fast)
                return true;
        }
    }
}
