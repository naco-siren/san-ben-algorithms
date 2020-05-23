package leetcode.LC_143;

import base.ListNode;

import java.util.Stack;

/**
 * 143. Reorder List
 */
class Solution143 {

    /**
     *
     *
     * Approach #1: Space O(1)
     *
     *
     */
    void reorderList(ListNode head) {
        if (head == null) return;

        // find the middle of linked list [Problem 876]
        // in 1->2->3->4->5->6 find 4
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second part of the list [Problem 206]
        // convert 1->2->3->4->5->6 into 1->2->3->4 and 6->5->4
        // reverse the second half in-place
        ListNode prev = null, curr = slow, next;
        while (curr != null) {
            // Cache `curr` node's next node
            next = curr.next;

            // Append `prev` node as `curr`'s next
            curr.next = prev;

            // Update references
            prev = curr;
            curr = next;
        }

        // merge two sorted linked lists [Problem 21]
        // merge 1->2->3->4 and 6->5->4 into 1->6->2->5->3->4
        ListNode tail1 = head, tail2 = prev;   // NOTE THE `prev`'s USAGE HERE!
        while (tail2.next != null) {
            // Cache `tail1`'s original next
            next = tail1.next;

            // Append `tail2` to `tail1`'s next
            tail1.next = tail2;
            tail1 = next;

            // Append `tail1`'s original next to `tail2`'s next
            next = tail2.next;
            tail2.next = tail1;
            tail2 = next;
        }
    }


    /**
     *
     *
     * Approach #2: Space O(n)
     *
     *
     */
    void reorderList2(ListNode head) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;

        // Split the list into two halves
        ListNode fast = sentinel, slow = sentinel;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            fast = fast.next;

            slow = slow.next;
        }
        ListNode latter = slow.next;
        slow.next = null;

        // Reverse the second half by pushing them into a stack
        Stack<ListNode> reversed = new Stack<>();
        while (latter != null) {
            reversed.push(latter);
            latter = latter.next;
        }

        // Merge two sub-lists
        ListNode probe = sentinel.next, next = null;
        while (probe != null && !reversed.isEmpty()) {
            next = probe.next;
            ListNode revNode = reversed.pop();
            probe.next = revNode;
            revNode.next = next;
            probe = next;
        }
    }
}
