package leetcode.LC_082;

import base.ListNode;

/**
 * Created by naco_siren on 7/15/17.
 */
public class Solution {
    public static void main(String[] args) {

        ListNode node5 = new ListNode(4);
        ListNode node4 = new ListNode(4); node4.next = node5;
        ListNode node3 = new ListNode(3); node3.next = node4;
        ListNode node2 = new ListNode(2); node2.next = node3;
        ListNode node1 = new ListNode(2); node1.next = node2;
        ListNode head = new ListNode(1); head.next = node1;

        ListNode r1 = deleteDuplicates(head);

        return;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        int lastVal = head == null ? 0 : head.val + 1;
        ListNode sentinel = new ListNode(0), tail = sentinel;

        while (head != null) {
            if (head.val != lastVal && (head.next == null || head.val != head.next.val)) {
                tail.next = head;
                tail = head;
            }
            lastVal = head.val;
            head = head.next;
        }
        tail.next = null;

        return sentinel.next;
    }
}
