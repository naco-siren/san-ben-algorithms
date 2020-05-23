package leetcode.LC_098;

import base.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution98Test {

    @Test
    public void isValidBST_2_1_3() {
        TreeNode n21 = new TreeNode(1);
        TreeNode n22 = new TreeNode(3);
        TreeNode n11 = new TreeNode(2); n11.left = n21; n11.right = n22;
        assertTrue(new Solution98().isValidBST(n11));
    }

    @Test
    public void isValidBST_5_1_4_null_null_3_6() {
        TreeNode n33 = new TreeNode(3);
        TreeNode n34 = new TreeNode(6);
        TreeNode n21 = new TreeNode(1);
        TreeNode n22 = new TreeNode(4); n22.left = n33; n22.right = n34;
        TreeNode n11 = new TreeNode(5); n11.left = n21; n11.right = n22;
        assertFalse(new Solution98().isValidBST(n11));
    }

    @Test
    public void isValidBST_2147483647() {
        TreeNode n11 = new TreeNode(2147483647);
        assertTrue(new Solution98().isValidBST(n11));
    }
}