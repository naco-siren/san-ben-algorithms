package leetcode.LC_086;

import base.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution86Test {

    @Test
    public void partition_1_4_3_2_5_2__3() {
        ListNode head = ListNode.generateLinkedList(new int[]{1, 4, 3, 2, 5, 2});

        ListNode result = new Solution86().partition(head, 3);

        assertTrue(ListNode.linkedListEquals(new int[]{1, 2, 2, 4, 3, 5}, result));
    }
}