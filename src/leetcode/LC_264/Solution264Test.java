package leetcode.LC_264;

import base.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution264Test {

    @Test
    public void isPalindrome_1() {
        ListNode input = ListNode.generateLinkedList(new int[]{1});
        assertTrue(new Solution264().isPalindrome(input));
    }

    @Test
    public void isPalindrome_1_2() {
        ListNode input = ListNode.generateLinkedList(new int[]{1,2});
        assertFalse(new Solution264().isPalindrome(input));
    }

    @Test
    public void isPalindrome_1_2_1() {
        ListNode input = ListNode.generateLinkedList(new int[]{1,2,1});
        assertTrue(new Solution264().isPalindrome(input));
    }

    @Test
    public void isPalindrome_1_2_2_1() {
        ListNode input = ListNode.generateLinkedList(new int[]{1,2,2,1});
        assertTrue(new Solution264().isPalindrome(input));
    }
}