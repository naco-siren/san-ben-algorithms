package leetcode.LC_109;

import base.ListNode;
import base.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution109Test {

    @Test
    public void sortedListToBST_empty() {
        ListNode input = ListNode.generateLinkedList(new int[]{});
        TreeNode output = new Solution109().sortedListToBST(input);

        assertNull(output);
    }

    @Test
    public void sortedListToBST_0_3_7_10_15() {
        ListNode input = ListNode.generateLinkedList(new int[]{0, 3, 7, 10, 15});
        TreeNode output = new Solution109().sortedListToBST(input);

        assertEquals(7, output.val);
        assertEquals(3, output.left.val);
        assertEquals(0, output.left.left.val);
        assertEquals(15, output.right.val);
        assertEquals(10, output.right.left.val);
    }
}