package leetcode.LC_369;

import base.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution369Test {

    @Test
    public void plusOne_1() {
        ListNode input = ListNode.generateLinkedList(new int[]{1});
        assertTrue(ListNode.linkedListEquals(new int[]{2}, new Solution369().plusOne(input)));
    }

    @Test
    public void plusOne_9() {
        ListNode input = ListNode.generateLinkedList(new int[]{9});
        assertTrue(ListNode.linkedListEquals(new int[]{1, 0}, new Solution369().plusOne(input)));
    }

    @Test
    public void plusOne_9_9_9() {
        ListNode input = ListNode.generateLinkedList(new int[]{9, 9, 9});
        assertTrue(ListNode.linkedListEquals(new int[]{1, 0, 0, 0}, new Solution369().plusOne(input)));
    }

    @Test
    public void plusOne_1_9_9_9_9() {
        ListNode input = ListNode.generateLinkedList(new int[]{1, 9, 9, 9, 9});
        assertTrue(ListNode.linkedListEquals(new int[]{2, 0, 0, 0, 0}, new Solution369().plusOne(input)));
    }

    @Test
    public void plusOne_1_9_9_9_8() {
        ListNode input = ListNode.generateLinkedList(new int[]{1, 9, 9, 9, 8});
        assertTrue(ListNode.linkedListEquals(new int[]{1, 9, 9, 9, 9}, new Solution369().plusOne(input)));
    }
}