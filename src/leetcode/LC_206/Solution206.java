package leetcode.LC_206;

import base.ListNode;

/**
 * 206. Reverse Linked List
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode iter = head;
        while (iter != null) {
            ListNode next = iter.next;
            iter.next = prev;
            prev = iter;
            iter = next;
        }
        return prev;
    }
}
