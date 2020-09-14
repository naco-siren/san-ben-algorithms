package leetcode.LC_024;

import base.ListNode;

/**
 * 24. Swap Nodes in Pairs
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode iter = sentinel;
        while (iter.next != null) {
            ListNode first = iter.next;
            ListNode second = first.next;
            if (second == null)
                break;
            ListNode next = second.next;

            iter.next = second;
            second.next = first;
            first.next = next;

            iter = first;
        }

        return sentinel.next;
    }

    // Improve the while loop condition
    public ListNode swapPairs2(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode iter = sentinel;   // essentially `prev`
        while (iter.next != null && iter.next.next != null) {
            ListNode first = iter.next;
            ListNode second = first.next;
            ListNode third = second.next;

            iter.next = second;
            second.next = first;    // This line is interchangable with...
            first.next = third;     // ... the next line.

            iter = first;
        }

        return sentinel.next;
    }

    // Remove the unnecessary variable of `third`
    public ListNode swapPairs3(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode iter = sentinel;
        while (iter.next != null && iter.next.next != null) {
            ListNode first = iter.next;
            ListNode second = first.next;

            iter.next = second;
            first.next = second.next;
            second.next = first;

            iter = first;
        }

        return sentinel.next;
    }
}
