package leetcode.LC_105;

import base.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution105Test {

    @Test
    public void buildTree() {
        /*
         *      4
         *     / \
         *    2   5
         *   /\
         *  1 3
         */
        TreeNode result = new Solution105().buildTree(new int[]{4, 2, 1, 3, 5}, new int[]{1, 2, 3, 4, 5});

        assertEquals(4, result.val);
        assertEquals(2, result.left.val);
        assertEquals(1, result.left.left.val);
        assertNull(result.left.left.left);
        assertNull(result.left.left.right);
        assertEquals(3, result.left.right.val);
        assertNull(result.left.right.left);
        assertNull(result.left.right.right);
        assertEquals(5, result.right.val);
        assertNull(result.right.left);
        assertNull(result.right.right);
    }
}