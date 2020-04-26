package leetcode.LC_002;

import base.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution2Test {

    @Test
    public void addTwoNumbers_0_0() {
        ListNode l11 = new ListNode(0);
        ListNode l21 = new ListNode(0);
        ListNode result = new Solution2().addTwoNumbers(l11, l21);
        assertEquals(0, result.val);
    }

    @Test
    public void addTwoNumbers_4_3() {
        ListNode l11 = new ListNode(4);
        ListNode l21 = new ListNode(3);
        ListNode result = new Solution2().addTwoNumbers(l11, l21);
        assertEquals(7, result.val);
    }

    @Test
    public void addTwoNumbers_5_5() {
        ListNode l11 = new ListNode(5);
        ListNode l21 = new ListNode(5);
        ListNode result = new Solution2().addTwoNumbers(l11, l21);
        assertEquals(0, result.val);
        assertEquals(1, result.next.val);
    }

    @Test
    public void addTwoNumbers_342_465() {
        ListNode l13 = new ListNode(3);
        ListNode l12 = new ListNode(4); l12.next = l13;
        ListNode l11 = new ListNode(2); l11.next = l12;

        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(6); l22.next = l23;
        ListNode l21 = new ListNode(5); l21.next = l22;

        ListNode result = new Solution2().addTwoNumbers(l11, l21);
        assertEquals(7, result.val);
        assertEquals(0, result.next.val);
        assertEquals(8, result.next.next.val);
    }
}