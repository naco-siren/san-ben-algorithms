package leetcode.LC_1123;

import base.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution1123Test {

    @Test
    public void lcaDeepestLeaves_1() {
        TreeNode n1 = new TreeNode(1);

        TreeNode result = new Solution1123().lcaDeepestLeaves(n1);

        assertEquals(1, result.val);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    public void lcaDeepestLeaves_1_2() {
        TreeNode n21 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        n1.left = n21;

        TreeNode result = new Solution1123().lcaDeepestLeaves(n1);

        assertEquals(2, result.val);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    public void lcaDeepestLeaves_1_3() {
        TreeNode n22 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1);
        n1.right = n22;

        TreeNode result = new Solution1123().lcaDeepestLeaves(n1);

        assertEquals(3, result.val);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    public void lcaDeepestLeaves_1_2_3() {
        TreeNode n21 = new TreeNode(2);
        TreeNode n22 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1);
        n1.left = n21; n1.right = n22;

        TreeNode result = new Solution1123().lcaDeepestLeaves(n1);

        assertEquals(1, result.val);
        assertEquals(2, result.left.val);
        assertNull(result.left.left);
        assertNull(result.left.right);
        assertEquals(3, result.right.val);
        assertNull(result.right.left);
        assertNull(result.right.right);
    }

    @Test
    public void lcaDeepestLeaves_wtf() {

        TreeNode n41 = new TreeNode(3);
        TreeNode n42 = new TreeNode(4);
        TreeNode n31 = new TreeNode(3);
        TreeNode n32 = new TreeNode(4);
        n31.right = n41; n32.right = n42;
        TreeNode n21 = new TreeNode(2);
        n21.left = n31; n21.right = n32;
        TreeNode n1 = new TreeNode(1);
        n1.left = n21;

        TreeNode result = new Solution1123().lcaDeepestLeaves(n1);

        assertEquals(2, result.val);
    }
}