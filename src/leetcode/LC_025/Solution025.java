package leetcode.LC_025;

import base.ListNode;

/**
 * 25. Reverse Nodes in k-Group
 */
public class Solution025 {
    public ListNode swapByGroup(ListNode head, int k) {
        if (head == null) return head;

        ListNode sentinel = new ListNode(0); sentinel.next = head;
        ListNode iter = sentinel;

        while (true) {
            /* Check if a group exists */
            ListNode probe = iter;
            for (int i = 0; i < k; i++) {
                probe = probe.next;
                if (probe == null)
                    return sentinel.next;
            }

            /* Perform reversing */
            ListNode anchor = iter.next;            // `anchor`: the first node in the current sublist of size `k`.
            for (int i = 0; i < k - 1; i++) {       // A smart loop that executes exactly `k-1` times.

                // Keep `anchor` reference, meanwhile keep moving the node on the right to the top of the sublist (right behind `iter`)
                ListNode next = anchor.next;
                anchor.next = next.next;
                next.next = iter.next;
                iter.next = next;
            }

            /* Update captain */
            iter = anchor;
        }

    }
}
