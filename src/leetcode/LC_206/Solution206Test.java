package leetcode.LC_206;

import base.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution206Test {

    @Test
    public void reverseList_empty() {
        ListNode input = ListNode.generateLinkedList(new int[]{});
        ListNode output = new Solution206().reverseList(input);

        assertNull(output);
    }

    @Test
    public void reverseList_1() {
        ListNode input = ListNode.generateLinkedList(new int[]{1});
        ListNode output = new Solution206().reverseList(input);

        assertTrue(ListNode.linkedListEquals(new int[]{1}, output));
    }

    @Test
    public void reverseList_1_2_3_4_5() {
        ListNode input = ListNode.generateLinkedList(new int[]{1, 2, 3, 4, 5});
        ListNode output = new Solution206().reverseList(input);

        assertTrue(ListNode.linkedListEquals(new int[]{5,4,3,2,1}, output));
    }
}