package leetcode.LC_237;

import base.ListNode;

/**
 * 237. Delete Node in a Linked List
 */
public class Solution237 {
    // In fact just assign next node's val to given node, then delete the next node
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

//    public void deleteNode(ListNode node) {
//        ListNode curr = node;
//        while (curr.next != null) {
//            ListNode next = curr.next;
//            curr.val = next.val;
//            if (next.next == null) {
//                curr.next = null;
//                return;
//            }
//            curr = next;
//        }
//    }
}
