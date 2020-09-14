package leetcode.LC_024;

import base.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution24Test {

    @Test
    public void swapPairs_empty() {
        ListNode n1 = null;

        ListNode r = new Solution24().swapPairs3(n1);

        assertNull(r);
    }

    @Test
    public void swapPairs_1() {
        ListNode n1 = new ListNode(1);

        ListNode r = new Solution24().swapPairs3(n1);

        assertEquals(1, r.val); r = r.next;
        assertNull(r);
    }

    @Test
    public void swapPairs_1_2_3() {
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);  n2.next = n3;
        ListNode n1 = new ListNode(1);  n1.next = n2;

        ListNode r = new Solution24().swapPairs3(n1);

        assertEquals(2, r.val); r = r.next;
        assertEquals(1, r.val); r = r.next;
        assertEquals(3, r.val); r = r.next;
        assertNull(r);
    }

    @Test
    public void swapPairs_1_2_3_4() {
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3);  n3.next = n4;
        ListNode n2 = new ListNode(2);  n2.next = n3;
        ListNode n1 = new ListNode(1);  n1.next = n2;

        ListNode r = new Solution24().swapPairs3(n1);

        assertEquals(2, r.val); r = r.next;
        assertEquals(1, r.val); r = r.next;
        assertEquals(4, r.val); r = r.next;
        assertEquals(3, r.val); r = r.next;
        assertNull(r);
    }
}