package leetcode.LC_061;

import base.ListNode;

/**
 * 61. Rotate List
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;

        int len = getListNodeLength(head);

        final int delta = k % len;

        return rotateRightInternal(head, delta);
    }

    int getListNodeLength(ListNode head) {
        ListNode iter = head;
        int counter = 0;
        while (head != null) {
            counter++;
            head = head.next;
        }
        return counter;
    }

    ListNode rotateRightInternal(ListNode head, int delta) {
        if (delta == 0)
            return head;

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        // Let `fast` pointer run ahead for `delta` steps
        ListNode fast = sentinel;
        while (delta-- > 0)
            fast = fast.next;

        // Increment both `slow` and `fast` pointer until `fast` reaches the tail
        ListNode slow = sentinel;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Reverse the two parts ahead of and behind `slow` pointer
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = sentinel.next;
        sentinel.next = newHead;

        return sentinel.next;
    }
}
