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
     * Approach #1.1: Space O(1) optimized!
     *
     *
     */
    void reorderList(ListNode head) {
        // Use a sentinel as `head`'s previous node for better traversing
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;

        // find the middle of linked list [Problem 876]
        // In [1 -> 2 -> 3 -> 4 -> 5], find `3` as `slow`, or: in [1 -> 2 -> 3 -> 4], find `2` as `slow`.
        //
        // Therefore, we need `slow.next` as second half's start node.
        //
        ListNode slow = sentinel, fast = sentinel;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Cut off first half from second half
        ListNode latter = slow.next;
        slow.next = null;

        // Reverse the second part of the list in-place
        //
        // e.g. convert [1 -> 2 -> 3 -> 4 -> 5] into [1 -> 2 -> 3] and [5 -> 4]
        // OR: convert [1 -> 2 -> 3 -> 4] into [1 -> 2] and [4 -> 3]
        //
        ListNode prev = null, curr = latter, next;
        while (curr != null) {
            // Cache `curr` node's next node
            next = curr.next;

            // Append `prev` node as `curr`'s next
            curr.next = prev;

            // Update references
            prev = curr;
            curr = next;
        }

        // Merge two sorted linked lists
        //
        // e.g. merge [1 -> 2 -> 3] and [5 -> 4] into [1 -> 5 -> 2 -> 4 -> 3]
        // OR: merge [1 -> 2] and [4 -> 3] into [1 -> 4 -> 2 -> 3]
        //
        ListNode tail1 = head, tail2 = prev;   // NOTE THE `prev`'s USAGE HERE!
        while (tail2 != null) {    // SEE COMMENT ABOVE
            // Cache `tail1`'s original next
            next = tail1.next;

            // Append `tail2` to `tail1`'s next, update `tail1` as its original next
            tail1.next = tail2;
            tail1 = next;

            // Cache `tail2`'s original next
            next = tail2.next;

            // Append `tail1`'s original next to `tail2`'s next
            tail2.next = tail1;
            tail2 = next;
        }
    }

    /**
     *
     *
     * Approach #1: Space O(1) original
     *
     *
     */
    void reorderList1(ListNode head) {
        if (head == null) return;

        // find the middle of linked list [Problem 876]
        // in 1->2->3->4->5->6 find 4
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second part of the list [Problem 206] in-place
        // convert 1 -> 2 -> 3 -> 4 -> 5 -> 6 into 1 -> 2 -> 3 -> 4 and 6 -> 5 -> 4
        // OR: convert 1 -> 2 -> 3 -> 4 into 1 -> 2 -> 3 and 4 -> 3
        //
        // Note that the lingering `4` or `3` in the first sub-list, this is because we didn't cut off `slow`'s prev's next.
        // Therefore, we need to fix it in the end.
        //
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
        // merge 1 -> 2 -> 3 -> 4 and 6 -> 5 -> 4 into 1 -> 6 -> 2 -> 5 -> 3 -> 4
        // OR: merge 1 -> 2 -> 3 and 4 -> 3 into 1 -> 4 -> 2 -> 3
        //
        // Note that the lingering `4` or `3` in the first sub-list of the above two examples,
        // is also the last item of the second sub-list.
        //
        // This means that we can just leave it as it is, and guard it with `tail2.next != null` condition.
        // Otherwise, we'll get [1, 4, 2, 3 (first), 3 (second)]
        //
        ListNode tail1 = head, tail2 = prev;   // NOTE THE `prev`'s USAGE HERE!
        while (tail2.next != null) {    // SEE COMMENT ABOVE
            // Cache `tail1`'s original next
            next = tail1.next;

            // Append `tail2` to `tail1`'s next, update `tail1` as its original next
            tail1.next = tail2;
            tail1 = next;

            // Cache `tail2`'s original next
            next = tail2.next;

            // Append `tail1`'s original next to `tail2`'s next
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
