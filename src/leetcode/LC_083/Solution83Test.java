package leetcode.LC_083;

import base.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution83Test {

    @Test
    public void deleteDuplicates_1() {
        ListNode n1 = new ListNode(1);

        ListNode r = new Solution83().deleteDuplicates(n1);
        assertEquals(1, r.val);     r = r.next;
        assertNull(r);
    }

    @Test
    public void deleteDuplicates_1_1_1() {
        ListNode n3 = new ListNode(1);
        ListNode n2 = new ListNode(1);  n2.next = n3;
        ListNode n1 = new ListNode(1);  n1.next = n2;

        ListNode r = new Solution83().deleteDuplicates(n1);
        assertEquals(1, r.val);     r = r.next;
        assertNull(r);
    }

    @Test
    public void deleteDuplicates_1_1_2_3_3() {
        ListNode n5 = new ListNode(3);
        ListNode n4 = new ListNode(3);  n4.next = n5;
        ListNode n3 = new ListNode(2);  n3.next = n4;
        ListNode n2 = new ListNode(1);  n2.next = n3;
        ListNode n1 = new ListNode(1);  n1.next = n2;

        ListNode r = new Solution83().deleteDuplicates(n1);
        assertEquals(1, r.val);     r = r.next;
        assertEquals(2, r.val);     r = r.next;
        assertEquals(3, r.val);     r = r.next;
        assertNull(r);
    }
}