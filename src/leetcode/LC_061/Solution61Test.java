package leetcode.LC_061;

import base.ListNode;
import leetcode.LC_024.Solution24;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution61Test {

    @Test
    public void rotateRight_empty__0() {
        ListNode n1 = null;

        ListNode r = new Solution61().rotateRight(n1, 0);

        assertNull(r);
    }

    @Test
    public void rotateRight_empty__7() {
        ListNode n1 = null;

        ListNode r = new Solution61().rotateRight(n1, 7);

        assertNull(r);
    }

    @Test
    public void rotateRight_1_2_3_4_5__0() {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4);  n4.next = n5;
        ListNode n3 = new ListNode(3);  n3.next = n4;
        ListNode n2 = new ListNode(2);  n2.next = n3;
        ListNode n1 = new ListNode(1);  n1.next = n2;

        ListNode r = new Solution61().rotateRight(n1, 0);

        assertEquals(1, r.val); r = r.next;
        assertEquals(2, r.val); r = r.next;
        assertEquals(3, r.val); r = r.next;
        assertEquals(4, r.val); r = r.next;
        assertEquals(5, r.val); r = r.next;
        assertNull(r);
    }

    @Test
    public void rotateRight_1_2_3_4_5__2() {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4);  n4.next = n5;
        ListNode n3 = new ListNode(3);  n3.next = n4;
        ListNode n2 = new ListNode(2);  n2.next = n3;
        ListNode n1 = new ListNode(1);  n1.next = n2;

        ListNode r = new Solution61().rotateRight(n1, 2);

        assertEquals(4, r.val); r = r.next;
        assertEquals(5, r.val); r = r.next;
        assertEquals(1, r.val); r = r.next;
        assertEquals(2, r.val); r = r.next;
        assertEquals(3, r.val); r = r.next;
        assertNull(r);
    }

    @Test
    public void rotateRight_1_2_3_4_5__8() {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4);  n4.next = n5;
        ListNode n3 = new ListNode(3);  n3.next = n4;
        ListNode n2 = new ListNode(2);  n2.next = n3;
        ListNode n1 = new ListNode(1);  n1.next = n2;

        ListNode r = new Solution61().rotateRight(n1, 8);

        assertEquals(3, r.val); r = r.next;
        assertEquals(4, r.val); r = r.next;
        assertEquals(5, r.val); r = r.next;
        assertEquals(1, r.val); r = r.next;
        assertEquals(2, r.val); r = r.next;
        assertNull(r);
    }
}