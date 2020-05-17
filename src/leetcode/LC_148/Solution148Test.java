package leetcode.LC_148;

import base.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution148Test {

    @Test
    public void sortList_null() {
        assertNull(new Solution148().sortList(null));
    }

    @Test
    public void sortList_odd() {
        ListNode n5 = new ListNode(0);
        ListNode n4 = new ListNode(4);  n4.next = n5;
        ListNode n3 = new ListNode(3);  n3.next = n4;
        ListNode n2 = new ListNode(5);  n2.next = n3;
        ListNode n1 = new ListNode(-1); n1.next = n2;

        ListNode r1 = new Solution148().sortList(n1);

        assertEquals(-1, r1.val);   r1 = r1.next;
        assertEquals(0, r1.val);   r1 = r1.next;
        assertEquals(3, r1.val);   r1 = r1.next;
        assertEquals(4, r1.val);   r1 = r1.next;
        assertEquals(5, r1.val);   r1 = r1.next;
        assertNull(r1);
    }

    @Test
    public void sortList_even() {
        ListNode n4 = new ListNode(3);
        ListNode n3 = new ListNode(1);  n3.next = n4;
        ListNode n2 = new ListNode(2);  n2.next = n3;
        ListNode n1 = new ListNode(4); n1.next = n2;

        ListNode r1 = new Solution148().sortList(n1);

        assertEquals(1, r1.val);   r1 = r1.next;
        assertEquals(2, r1.val);   r1 = r1.next;
        assertEquals(3, r1.val);   r1 = r1.next;
        assertEquals(4, r1.val);   r1 = r1.next;
        assertNull(r1);
    }
}