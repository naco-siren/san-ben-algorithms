package leetcode.LC_083;

import base.ListNode;

/**
 * 83. Remove Duplicates from Sorted List
 */
public class Solution83 {
    /*
     * Approach 1: delete duplicate node in-place pairwise
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode iter = head;
        while (iter != null && iter.next != null) {
            if (iter.next.val == iter.val) {
                iter.next = iter.next.next;
            } else {
                iter = iter.next;
            }
        }
        return head;
    }


    /*
     * Approach 2: append new value to a new head
     */
//    public ListNode deleteDuplicates2(ListNode head) {
//        ListNode sentinel = new ListNode(0);
//        ListNode iter = head, tail = sentinel;
//        Integer prevVal = null;
//        while (iter != null) {
//            if (prevVal == null) {
//                tail.next = iter;
//                prevVal = iter.val;
//
//                tail = tail.next;
//
//            } else {
//                if (iter.val != prevVal) {
//                    tail.next = iter;
//                    prevVal = iter.val;
//
//                    tail = tail.next;
//                }
//            }
//
//            iter = iter.next;
//        }
//        tail.next = null;
//        return sentinel.next;
//    }
}
