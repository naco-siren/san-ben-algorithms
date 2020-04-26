package leetcode.LC_019;

import base.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution19Test {

    @Test
    public void removeNthFromEnd_0() {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4);  l4.next = l5;
        ListNode l3 = new ListNode(3);  l3.next = l4;
        ListNode l2 = new ListNode(2);  l2.next = l3;
        ListNode l1 = new ListNode(1);  l1.next = l2;

        ListNode result = new Solution19().removeNthFromEnd(l1, 2);
        assertEquals(1, result.val);    result = result.next;
        assertEquals(2, result.val);    result = result.next;
        assertEquals(3, result.val);    result = result.next;
        assertEquals(5, result.val);    result = result.next;
        assertNull(result);
    }

    @Test
    public void removeNthFromEnd_1() {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4);  l4.next = l5;
        ListNode l3 = new ListNode(3);  l3.next = l4;
        ListNode l2 = new ListNode(2);  l2.next = l3;
        ListNode l1 = new ListNode(1);  l1.next = l2;

        ListNode result = new Solution19().removeNthFromEnd(l1, 5);
        assertEquals(2, result.val);    result = result.next;
        assertEquals(3, result.val);    result = result.next;
        assertEquals(4, result.val);    result = result.next;
        assertEquals(5, result.val);    result = result.next;
        assertNull(result);
    }
}