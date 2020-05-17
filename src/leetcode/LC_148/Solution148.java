package leetcode.LC_148;

import base.ListNode;

/**
 * 148. Sort List
 *
 * Sort a linked list in O(n log n) time using "CONSTANT" space complexity.
 */
class Solution148 {
    ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Cut the linkedlist in half
        ListNode slow = head, fast = head;
        ListNode lastSlow = null;
        while (fast != null && fast.next != null) {
            lastSlow = slow;
            slow = slow.next;
            fast = fast.next.next;  // `fast` is probing ahead
        }
        lastSlow.next = null;   // "CUT" first half from second half

        // Recursively merge
        return merge(sortList(head), sortList(slow));   // NOTE THAT `head` and `slow` are the 0 and 1/2, we don't use `fast` for recursion
    }

    /**
     * Merge two linked-lists in an ordinary way
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        final ListNode sentinel = new ListNode(-1);

        ListNode tail = sentinel;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;

            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        if (l1 != null)
            tail.next = l1;
        if (l2 != null)
            tail.next = l2;
        return sentinel.next;
    }
}
