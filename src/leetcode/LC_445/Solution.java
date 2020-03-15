package leetcode.LC_445;

import base.ListNode;

import java.util.Stack;

/**
 * 445. Add Two Numbers II
 */
class Solution {
    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // Push Linked Lists into Stacks to obtain reversed Linked Lists.
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }

        // Perform regular linked list addition.
        ListNode tail = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
            int v1 = s1.isEmpty() ? 0 : s1.pop().val;
            int v2 = s2.isEmpty() ? 0 : s2.pop().val;
            int sum = v1 + v2 + carry;
            carry = sum / 10;

            ListNode next = new ListNode(sum % 10);
            next.next = tail;
            tail = next;
        }
        return tail;
    }
}
