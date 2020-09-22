package leetcode.LC_025;

import base.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution25Test {

    @Test
    public void swapByGroup_1_2_3_4_5__2() {
        ListNode input = ListNode.generateLinkedList(new int[]{1,2,3,4,5});
        ListNode output = new Solution025().swapByGroup(input, 2);
        assertTrue(ListNode.linkedListEquals(new int[]{2,1,4,3,5}, output));
    }

    @Test
    public void swapByGroup_1_2_3_4_5__3() {
        ListNode input = ListNode.generateLinkedList(new int[]{1,2,3,4,5});
        ListNode output = new Solution025().swapByGroup(input, 3);
        assertTrue(ListNode.linkedListEquals(new int[]{3,2,1,4,5}, output));
    }

}