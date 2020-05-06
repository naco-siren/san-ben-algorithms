package leetcode.LC_328;

import base.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution328Test {

    @Test
    public void oddEvenList_() {
        assertNull(new Solution328().oddEvenList(null));
    }


    @Test
    public void oddEvenList_1() {
        ListNode n1 = new ListNode(1);

        ListNode result = new Solution328().oddEvenList(n1);

        assertEquals(n1.val, result.val);
        assertNull(n1.next);
    }

    @Test
    public void oddEvenList_1_2() {
        ListNode n2 = new ListNode(2);
        ListNode n1 = new ListNode(1); n1.next = n2;

        ListNode result = new Solution328().oddEvenList(n1);

        assertEquals(n1.val, result.val);
        assertEquals(n2.val, n1.next.val);
        assertNull(n1.next.next);
    }

    @Test
    public void oddEvenList_1_2_3() {
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2); n2.next = n3;
        ListNode n1 = new ListNode(1); n1.next = n2;

        ListNode result = new Solution328().oddEvenList(n1);

        assertEquals(n1.val, result.val);
        result = result.next;
        assertEquals(n3.val, result.val);
        result = result.next;
        assertEquals(n2.val, result.val);
        result = result.next;
        assertNull(result);
    }

    @Test
    public void oddEvenList_1_2_3_4() {
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        n3.next = n4;
        ListNode n2 = new ListNode(2);
        n2.next = n3;
        ListNode n1 = new ListNode(1);
        n1.next = n2;

        ListNode result = new Solution328().oddEvenList(n1);

        assertEquals(n1.val, result.val);
        result = result.next;
        assertEquals(n3.val, result.val);
        result = result.next;
        assertEquals(n2.val, result.val);
        result = result.next;
        assertEquals(n4.val, result.val);
        result = result.next;
        assertNull(result);
    }

    @Test
    public void oddEvenList_1_2_3_4_5() {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4); n4.next = n5;
        ListNode n3 = new ListNode(3); n3.next = n4;
        ListNode n2 = new ListNode(2); n2.next = n3;
        ListNode n1 = new ListNode(1); n1.next = n2;

        ListNode result = new Solution328().oddEvenList(n1);

        assertEquals(n1.val, result.val);
        result = result.next;
        assertEquals(n3.val, result.val);
        result = result.next;
        assertEquals(n5.val, result.val);
        result = result.next;
        assertEquals(n2.val, result.val);
        result = result.next;
        assertEquals(n4.val, result.val);
        result = result.next;
        assertNull(result);
    }
}