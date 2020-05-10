package leetcode.LC_270;

import base.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution270Test {

    @Test
    public void closestValue_0() {
        TreeNode n1 = new TreeNode(0);
        assertEquals(0, new Solution270().closestValue(n1, 2147483648.0));
    }

    @Test
    public void closestValue_1() {
        TreeNode n31 = new TreeNode(1);
        TreeNode n32 = new TreeNode(3);
        TreeNode n21 = new TreeNode(2);
        TreeNode n22 = new TreeNode(5);
        n21.left = n31; n21.right = n32;
        TreeNode n1 = new TreeNode(4);
        n1.left = n21; n1.right = n22;
        assertEquals(4, new Solution270().closestValue(n1, 3.714286));
    }
}