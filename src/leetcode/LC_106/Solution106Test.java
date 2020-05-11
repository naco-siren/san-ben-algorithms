package leetcode.LC_106;

import base.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution106Test {

    @Test
    public void buildTree() {
        /*
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         */

        TreeNode result = new Solution106().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});

        assertEquals(3, result.val);
        assertEquals(9, result.left.val);
        assertNull(result.left.left);
        assertNull(result.left.right);
        assertEquals(20, result.right.val);
        assertEquals(15, result.right.left.val);
        assertNull(result.right.left.left);
        assertNull(result.right.left.right);
        assertEquals(7, result.right.right.val);
        assertNull(result.right.right.left);
        assertNull(result.right.right.right);
    }
}