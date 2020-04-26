package leetcode.LC_023;

import base.ListNode;

import java.util.PriorityQueue;

/**
 * 23. Merge k Sorted Lists
 */
class Solution23 {
    ListNode mergeKLists(ListNode[] lists) {
        // Guard corner cases
        if (lists == null || lists.length == 0)
            return null;

        // Add the heads of all lists into an ascending priority queue
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (ListNode l1, ListNode l2) -> l1.val - l2.val
        );
        for (ListNode head : lists)
            if (head != null)
                pq.offer(head);

        // Keep polling from priority queue until all clear
        ListNode sentinel = new ListNode(Integer.MIN_VALUE), ranger = sentinel;
        while (!pq.isEmpty()) {
            final ListNode minNode = pq.poll();

            // Append polled node to sentinel
            ranger.next = minNode;
            ranger = minNode;

            // Offer the next node to Priority Queue if exist
            if (minNode.next != null)
                pq.offer(minNode.next);
        }
        return sentinel.next;
    }
}
