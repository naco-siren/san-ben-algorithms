package leetcode.LC_114;

import base.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution114Test {

    @Test
    public void flatten_1() {
        TreeNode n34 = new TreeNode(6);
        TreeNode n32 = new TreeNode(4);
        TreeNode n31 = new TreeNode(3);
        TreeNode n21 = new TreeNode(2); n21.left = n31; n21.right = n32;
        TreeNode n22 = new TreeNode(5); n22.right = n34;
        TreeNode n11 = new TreeNode(1); n11.left = n21; n11.right = n22;

        new Solution114().flattenRecur(n11);

        assertEquals(1, n11.val);
        assertNull(n11.left);   n11 = n11.right;
        assertEquals(2, n11.val);
        assertNull(n11.left);   n11 = n11.right;
        assertEquals(3, n11.val);
        assertNull(n11.left);   n11 = n11.right;
        assertEquals(4, n11.val);
        assertNull(n11.left);   n11 = n11.right;
        assertEquals(5, n11.val);
        assertNull(n11.left);   n11 = n11.right;
        assertEquals(6, n11.val);
        assertNull(n11.left);   assertNull(n11.right);
    }
}