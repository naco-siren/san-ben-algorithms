package leetcode.LC_021;

import base.ListNode;

/**
 * 21. Merge Two Sorted Lists
 */
class Solution21 {
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(Integer.MIN_VALUE), tail = sentinel;
        while (l1 != null || l2 != null) {
            final int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            final int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            if (val1 < val2) {
                tail.next = l1;
                tail = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                tail = l2;
                l2 = l2.next;
            }
        }
        return sentinel.next;
    }
}
