package leetcode.LC_082;

import base.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution82Test {

    @Test
    public void deleteDuplicates_1() {
        ListNode input = ListNode.generateLinkedList(new int[]{1});
        ListNode output = new Solution82().deleteDuplicates(input);
        assertTrue(ListNode.linkedListEquals(new int[]{1}, output));
    }

    @Test
    public void deleteDuplicates_1_2_2() {
        ListNode input = ListNode.generateLinkedList(new int[]{1,2,2});
        ListNode output = new Solution82().deleteDuplicates(input);
        assertTrue(ListNode.linkedListEquals(new int[]{1}, output));
    }

    @Test
    public void deleteDuplicates_1_1_1_2_3() {
        ListNode input = ListNode.generateLinkedList(new int[]{1,1,1,2,3});
        ListNode output = new Solution82().deleteDuplicates(input);
        assertTrue(ListNode.linkedListEquals(new int[]{2,3}, output));
    }

    @Test
    public void deleteDuplicates_1_2_3_3_4_4_5() {
        ListNode input = ListNode.generateLinkedList(new int[]{1,2,3,3,4,4,5});
        ListNode output = new Solution82().deleteDuplicates(input);
        assertTrue(ListNode.linkedListEquals(new int[]{1,2,5}, output));
    }
}