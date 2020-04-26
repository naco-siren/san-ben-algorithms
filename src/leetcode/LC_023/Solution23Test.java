package leetcode.LC_023;

import base.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution23Test {

    @Test
    public void mergeKLists_0() {
        ListNode result = new Solution23().mergeKLists(new ListNode[]{});
        assertNull(result);
    }

    @Test
    public void mergeKLists_1() {
        ListNode l13 = new ListNode(5);
        ListNode l12 = new ListNode(4); l12.next = l13;
        ListNode l11 = new ListNode(1); l11.next = l12;

        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(3); l22.next = l23;
        ListNode l21 = new ListNode(1); l21.next = l22;


        ListNode l32 = new ListNode(6);
        ListNode l31 = new ListNode(2); l31.next = l32;

        ListNode result = new Solution23().mergeKLists(new ListNode[]{l11, l21, l31});
        assertEquals(1, result.val);    result = result.next;
        assertEquals(1, result.val);    result = result.next;
        assertEquals(2, result.val);    result = result.next;
        assertEquals(3, result.val);    result = result.next;
        assertEquals(4, result.val);    result = result.next;
        assertEquals(4, result.val);    result = result.next;
        assertEquals(5, result.val);    result = result.next;
        assertEquals(6, result.val);    result = result.next;
        assertNull(result);
    }
}