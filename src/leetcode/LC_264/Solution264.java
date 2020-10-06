package leetcode.LC_264;

import base.ListNode;

/**
 * 234. Palindrome Linked List
 */
public class Solution264 {
    public boolean isPalindrome(ListNode head) {
        // Find out total nodes' count
        ListNode sentinel = new ListNode(Integer.MIN_VALUE);
        sentinel.next = head;

        int size = 0;
        ListNode iter = sentinel;
        while (iter.next != null) {
            size++;
            iter = iter.next;
        }

        // Reverse the first half
        int half = size / 2;
        ListNode prev = null;
        ListNode curr = head;
        while (half-- > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Compare first half with second half
        if (size % 2 == 1)
            curr = curr.next;

        while (curr != null) {
            if (curr.val != prev.val)
                return false;
            curr = curr.next;
            prev = prev.next;
        }
        return true;
    }
}
