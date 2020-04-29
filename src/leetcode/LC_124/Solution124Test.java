package leetcode.LC_124;

import base.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution124Test {

    @Test
    public void maxPathSum_0() {
        TreeNode n1 = new TreeNode(5);
        assertEquals(5, new Solution124().maxPathSum(n1));
    }

    @Test
    public void maxPathSum_1() {
        TreeNode n21 = new TreeNode(2);
        TreeNode n22 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1);  n1.left = n21; n1.right = n22;
        assertEquals(6, new Solution124().maxPathSum(n1));
    }

    @Test
    public void maxPathSum_2() {
        TreeNode n21 = new TreeNode(-2);
        TreeNode n1 = new TreeNode(1);  n1.left = n21;
        assertEquals(1, new Solution124().maxPathSum(n1));
    }

    @Test
    public void maxPathSum_3() {
        TreeNode n32 = new TreeNode(15);
        TreeNode n31 = new TreeNode(7);
        TreeNode n22 = new TreeNode(20);  n22.left = n31; n22.right = n32;
        TreeNode n21 = new TreeNode(9);
        TreeNode n1 = new TreeNode(-10);  n1.left = n21; n1.right = n22;
        assertEquals(42, new Solution124().maxPathSum(n1));
    }
}