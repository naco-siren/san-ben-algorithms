package leetcode.LC_1140;

import base.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution1140Test {

    TreeNode root;

    @Before
    public void setup(){
        /**
         *              0
         *           /   \
         *         1      0
         *       /  \    /
         *      0    1  0
         *      \   / \
         *      1  0  0
         */

        TreeNode n41 = new TreeNode(1);
        TreeNode n42 = new TreeNode(0);
        TreeNode n43 = new TreeNode(0);
        TreeNode n31 = new TreeNode(0); n31.right = n41;
        TreeNode n32 = new TreeNode(1); n32.left = n42;
        TreeNode n33 = new TreeNode(0); n32.right = n43;
        TreeNode n21 = new TreeNode(1); n21.left = n31; n21.right = n32;
        TreeNode n22 = new TreeNode(0); n22.left = n33;
        TreeNode n11 = new TreeNode(0); n11.left = n21; n11.right = n22;
        this.root = n11;
    }

    @Test
    public void isValidSequence_valid_sequence() {
        assertTrue(new Solution1140().isValidSequence(root, new int[]{0,1,0,1}));
    }

    @Test
    public void isValidSequence_not_a_sequence() {
        assertFalse(new Solution1140().isValidSequence(root, new int[]{0,0,1}));
    }

    @Test
    public void isValidSequence_invalid_sequence() {
        assertFalse(new Solution1140().isValidSequence(root, new int[]{0,1,0}));
    }
}