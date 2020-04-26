package leetcode.LC_019;

import base.ListNode;

/**
 * 19. Remove Nth Node From End of List
 */
class Solution19 {
    ListNode removeNthFromEnd(ListNode head, int n) {
        // Handle corner cases
        if (head == null || n < 0)
            return null;
        if (n == 0)
            return head;

        // Add a sentinel before head node
        final ListNode sentinel = new ListNode(Integer.MIN_VALUE);
        sentinel.next = head;

        // Find the node right before our target
        ListNode fast = sentinel, slow = sentinel;
        for (int i = 0; i < n; i++)
            fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // By now, slow is right before our target.
        slow.next = slow.next.next;
        return sentinel.next;
    }
}
