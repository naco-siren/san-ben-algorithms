package leetcode.LC_328;

import base.ListNode;

/**
 * 328. Odd Even Linked List
 */
class Solution328 {
    ListNode oddEvenList(ListNode head) {
        // Stupid corner case
        if (head == null)
            return null;

        // Sentinels for new odd list and new even list
        ListNode oddS = new ListNode(1), evenS = new ListNode(2);
        ListNode oddT = oddS, evenT = evenS;

        // Use `odd` and `even` pointers to probe the original list
        ListNode odd = head, even = head.next;
        while (odd != null) {
            // Append `odd` node to new odd list
            oddT.next = odd;
            oddT = odd;

            // Append `even` node to new even list, if not null
            if (even != null) {
                evenT.next = even;
                evenT = even;
            }

            // Probe the two pointers
            odd = even == null ? null : even.next;
            even = odd == null ? null : odd.next;
        }

        // Append new even list to the new odd list, then fix cycle on the tail node
        oddT.next = evenS.next;
        evenT.next = null;
        return oddS.next;
    }
}
