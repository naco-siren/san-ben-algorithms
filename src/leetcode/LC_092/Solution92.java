package leetcode.LC_092;

import base.ListNode;

/**
 * 92. Reverse Linked List II
 */
public class Solution92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null;

        // For iterating through the input linked list
        ListNode curr = head, next;

        // A new linked list `sentinel` and its iterator `tail`
        ListNode sentinel = new ListNode(0), tail = sentinel;

        // Another new linked list `revHead` to reverse the sublist
        ListNode revHead = null, revTail = null;

        for (int i = 1; i <= n; i++, curr = next) {     // PAY ATTENTION: DONT USE `curr = curr.next`!
            next = curr.next;                           // BECAUSE: `curr.next` is often corrupted, therefore `next` is cached here

            if (i < m) {
                tail.next = curr;
                tail = tail.next;
            } else {
                // Assign `revTail` only once, which will be used in the end to concatenate the rest of original list
                if (revTail == null)
                    revTail = curr;

                // Append using `revHead`
                curr.next = revHead;
                revHead = curr;
            }
        }

        // Concatenate `revHead` in between `sentinel` & rest of original list
        tail.next = revHead;
        revTail.next = curr;

        return sentinel.next;
    }
}
