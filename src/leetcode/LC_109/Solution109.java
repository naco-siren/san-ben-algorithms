package leetcode.LC_109;

import base.ListNode;
import base.TreeNode;

/**
 * 109. Convert Sorted List to Binary Search Tree
 */
public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        ListNode sentinel = new ListNode(Integer.MIN_VALUE);
        sentinel.next = head;

        // Find the node in the middle as `mid`
        ListNode slow = sentinel, fast = sentinel;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Cut off `mid` list node
        ListNode mid = slow.next;
        slow.next = null;

        // Recursion
        TreeNode node = new TreeNode(mid.val);
        node.left = sortedListToBST(slow == sentinel ? null : head);
        node.right = sortedListToBST(mid.next == null ? null : mid.next);
        return node;
    }
}
