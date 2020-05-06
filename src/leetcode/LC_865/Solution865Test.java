package leetcode.LC_865;

import base.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution865Test {

    @Test
    public void subtreeWithAllDeepest_0() {
        TreeNode n1 = new TreeNode(3);
        assertEquals(n1, new Solution865().subtreeWithAllDeepest(n1));
    }

    @Test
    public void subtreeWithAllDeepest_2() {
        TreeNode n21 = new TreeNode(5);
        TreeNode n1 = new TreeNode(3);  n1.left = n21;
        assertEquals(n21, new Solution865().subtreeWithAllDeepest(n1));
    }

    @Test
    public void subtreeWithAllDeepest_3() {
        TreeNode n21 = new TreeNode(5);
        TreeNode n22 = new TreeNode(1);
        TreeNode n1 = new TreeNode(3);  n1.left = n21;  n1.right = n22;
        assertEquals(n1, new Solution865().subtreeWithAllDeepest(n1));
    }

    @Test
    public void subtreeWithAllDeepest_4() {
        TreeNode n43 = new TreeNode(7);
        TreeNode n44 = new TreeNode(4);
        TreeNode n31 = new TreeNode(6);
        TreeNode n32 = new TreeNode(2); n32.left = n43; n32.right = n44;
        TreeNode n33 = new TreeNode(0);
        TreeNode n34 = new TreeNode(8);
        TreeNode n21 = new TreeNode(5); n21.left = n31; n21.right = n32;
        TreeNode n22 = new TreeNode(1); n22.left = n33; n22.right = n34;
        TreeNode n1 = new TreeNode(3);  n1.left = n21;  n1.right = n22;
        assertEquals(n32, new Solution865().subtreeWithAllDeepest(n1));
    }
}