package leetcode.LC_086;

import base.ListNode;

/**
 * 86. Partition List
 */
public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode sentinel1 = new ListNode(0), sentinel2 = new ListNode(0);

        ListNode tail1 = sentinel1, tail2 = sentinel2;
        for (ListNode iter = head; iter != null; iter = iter.next) {
            if (iter.val < x) {
                tail1.next = iter;
                tail1 = tail1.next;
            } else {
                tail2.next = iter;
                tail2 = tail2.next;
            }
        }

        tail1.next = sentinel2.next;
        tail2.next = null;
        return sentinel1.next;
    }
}
