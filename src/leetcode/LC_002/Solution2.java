package leetcode.LC_002;

import base.ListNode;

/**
 * 2. Add Two Numbers
 */
class Solution2 {
    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(Integer.MIN_VALUE), ranger = sentinel;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            final int digit1 = l1 == null ? 0 : l1.val;
            final int digit2 = l2 == null ? 0 : l2.val;

            final int sum = digit1 + digit2 + carry;
            ranger.next = new ListNode(sum >= 10 ? sum - 10 : sum);
            carry = sum >= 10 ? 1 : 0;

            ranger = ranger.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return sentinel.next;
    }
}
