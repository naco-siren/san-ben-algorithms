package leetcode.LC_082;

import base.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        Integer lastVal = null;
        ListNode sentinel = new ListNode(Integer.MIN_VALUE), tail = sentinel;

        for (ListNode iter = head; iter != null; lastVal = iter.val, iter = iter.next) {
            final boolean sameAsPrev = lastVal != null && lastVal == iter.val;
            final boolean sameAsNext = iter.next != null && iter.next.val == iter.val;
            if (!sameAsPrev && !sameAsNext) {
                tail.next = iter;
                tail = tail.next;
            }
        }

        tail.next = null;
        return sentinel.next;
    }
}
