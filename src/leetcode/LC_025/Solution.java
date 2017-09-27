package leetcode.LC_025;

import base.ListNode;

/**
 * Created by naco_siren on 9/8/17.
 */
public class Solution {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(4); node0.next = node1;
        ListNode node2 = new ListNode(2); node1.next = node2;
        ListNode node3 = new ListNode(8); node2.next = node3;
        ListNode node4 = new ListNode(5); node3.next = node4;
        ListNode node5 = new ListNode(7); node4.next = node5;
        ListNode node6 = new ListNode(1); node5.next = node6;
        ListNode node7 = new ListNode(4); node6.next = node7;
        ListNode node8 = new ListNode(2); node7.next = node8;
        ListNode node9 = new ListNode(8); node8.next = node9;
        String oldList = printList(node0);

        ListNode newHead = swapByGroup(node0, 4);
        String newList = printList(newHead);

        return;
    }

    public static ListNode swapByGroup(ListNode head, int k) {
        if (head == null) return head;

        ListNode sentinel = new ListNode(0); sentinel.next = head;
        ListNode captain = sentinel;

        while (true) {
            /* Check if a group exists */
            ListNode ranger = captain;
            for (int i = 0; i < k; i++) {
                ranger = ranger.next;
                if (ranger == null)
                    return sentinel.next;
            }

            /* Perform reversing */
            ListNode anchor = captain.next;
            for (int i = 0; i < k - 1; i++) {
                ListNode next = anchor.next;
                anchor.next = next.next;
                next.next = captain.next;
                captain.next = next;

                String curList = printList(sentinel.next);
                continue;
            }

            /* Update captain */
            captain = anchor;
        }

    }


    public static String printList(ListNode head) {
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append("" + head.val + ", ");
            head = head.next;
        }
        return builder.toString();
    }
}
