package leetcode.LC_092;

import base.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution92Test {

    @Test
    public void reverseBetween_1_2_3_4_5__2_4() {
        ListNode head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4, 5});

        ListNode result = new Solution92().reverseBetween(head, 2, 4);
        assertTrue(ListNode.linkedListEquals(new int[]{1, 4, 3, 2, 5}, result));
    }

    @Test
    public void reverseBetween_1_2_3_4_5__2_3() {
        ListNode head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4, 5});

        ListNode result = new Solution92().reverseBetween(head, 2, 3);
        assertTrue(ListNode.linkedListEquals(new int[]{1, 3, 2, 4, 5}, result));
    }

    @Test
    public void reverseBetween_1_2_3_4_5__2_2() {
        ListNode head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4, 5});

        ListNode result = new Solution92().reverseBetween(head, 2, 2);
        assertTrue(ListNode.linkedListEquals(new int[]{1, 2, 3, 4, 5}, result));
    }

    @Test
    public void reverseBetween_1_2_3_4_5__1_5() {
        ListNode head = ListNode.generateLinkedList(new int[]{1, 2, 3, 4, 5});

        ListNode result = new Solution92().reverseBetween(head, 1, 5);
        assertTrue(ListNode.linkedListEquals(new int[]{5, 4, 3, 2, 1}, result));
    }
}