package leetcode.LC_143;

import base.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution143Test {

    @Test
    public void reorderList_1() {
        ListNode l1 = new ListNode(1);
        new Solution143().reorderList(l1);
        assertEquals(1, l1.val);    l1 = l1.next;
        assertNull(l1);
    }

    @Test
    public void reorderList_1_2_3_4() {
        ListNode l4 = new ListNode(4);
        ListNode l3 = new ListNode(3);  l3.next = l4;
        ListNode l2 = new ListNode(2);  l2.next = l3;
        ListNode l1 = new ListNode(1);  l1.next = l2;
        new Solution143().reorderList(l1);
        assertEquals(1, l1.val);    l1 = l1.next;
        assertEquals(4, l1.val);    l1 = l1.next;
        assertEquals(2, l1.val);    l1 = l1.next;
        assertEquals(3, l1.val);    l1 = l1.next;
        assertNull(l1);
    }

    @Test
    public void reorderList_1_2_3_4_5() {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4);  l4.next = l5;
        ListNode l3 = new ListNode(3);  l3.next = l4;
        ListNode l2 = new ListNode(2);  l2.next = l3;
        ListNode l1 = new ListNode(1);  l1.next = l2;
        new Solution143().reorderList(l1);
        assertEquals(1, l1.val);    l1 = l1.next;
        assertEquals(5, l1.val);    l1 = l1.next;
        assertEquals(2, l1.val);    l1 = l1.next;
        assertEquals(4, l1.val);    l1 = l1.next;
        assertEquals(3, l1.val);    l1 = l1.next;
        assertNull(l1);
    }
}