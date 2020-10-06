package leetcode.LC_369;

import base.ListNode;

/**
 * 369. Plus One Linked List
 */
public class Solution369 {
    private static final int NINE = 9;

    public ListNode plusOne(ListNode head) {
        ListNode sentinel = new ListNode(Integer.MIN_VALUE);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;

        // Find out the previous node before consecutive nines suffix, if any
        boolean inNine = false;
        ListNode prevNine = null;

        while (curr != null) {
            if (inNine) {
                if (curr.val != NINE) {
                    inNine = false;
                    prevNine = null;
                }

            } else {
                if (curr.val == NINE) {
                    inNine = true;
                    prevNine = prev;
                }
            }

            prev = curr;
            curr = curr.next;
        }

        // Increment last digit by one
        if (!inNine) {
            prev.val = prev.val + 1;
            return head;
        }

        // Update all nines to be zero
        for (ListNode iter = prevNine.next; iter != null; iter = iter.next) {
            iter.val = 0;
        }

        if (prevNine != sentinel) {
            prevNine.val = prevNine.val + 1;
        } else {
            ListNode newNode = new ListNode(1);
            sentinel.next = newNode;
            newNode.next = head;
        }
        return sentinel.next;
    }
}
