package leetcode.LC_958;

import base.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution958Test {

    @Test
    public void isCompleteTree_1() {
        TreeNode r11 = new TreeNode(1);

        assertTrue(new Solution958().isCompleteTree(r11));
    }

    @Test
    public void isCompleteTree_2() {
        TreeNode r21 = new TreeNode(2);
        TreeNode r22 = new TreeNode(3);
        TreeNode r11 = new TreeNode(1); r11.left = r21; r11.right = r22;

        assertTrue(new Solution958().isCompleteTree(r11));
    }

    @Test
    public void isCompleteTree_3() {
        TreeNode r31 = new TreeNode(4);
        TreeNode r32 = new TreeNode(5);
        TreeNode r33 = new TreeNode(6);
        TreeNode r21 = new TreeNode(2); r21.left = r31; r21.right = r32;
        TreeNode r22 = new TreeNode(3); r22.left = r33;
        TreeNode r11 = new TreeNode(1); r11.left = r21; r11.right = r22;

        assertTrue(new Solution958().isCompleteTree(r11));
    }

    @Test
    public void isCompleteTree_4() {
        TreeNode r31 = new TreeNode(4);
        TreeNode r32 = new TreeNode(5);
        TreeNode r34 = new TreeNode(7);
        TreeNode r21 = new TreeNode(2); r21.left = r31; r21.right = r32;
        TreeNode r22 = new TreeNode(3); r22.right = r34;
        TreeNode r11 = new TreeNode(1); r11.left = r21; r11.right = r22;

        assertFalse(new Solution958().isCompleteTree(r11));
    }
}