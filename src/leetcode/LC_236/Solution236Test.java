package leetcode.LC_236;

import base.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 *         3
 *      /    \
 *    5       1
 *  /  \    /  \
 * 6   2   0   8
 *   /  \
 *  7   4
 */
public class Solution236Test {

    @Test
    public void lowestCommonAncestor_1() {
        TreeNode n43 = new TreeNode(7);
        TreeNode n44 = new TreeNode(4);

        TreeNode n31 = new TreeNode(6);
        TreeNode n32 = new TreeNode(2);
        n32.left = n43; n32.right = n44;
        TreeNode n33 = new TreeNode(0);
        TreeNode n34 = new TreeNode(8);

        TreeNode n21 = new TreeNode(5);
        n21.left = n31; n21.right = n32;
        TreeNode n22 = new TreeNode(1);
        n22.left = n33; n22.right = n34;

        TreeNode n11 = new TreeNode(3);
        n11.left = n21; n11.right = n22;

        assertEquals(n11, new Solution236().lowestCommonAncestor(n11, n21, n22));
    }

    @Test
    public void lowestCommonAncestor_2() {
        TreeNode n43 = new TreeNode(7);
        TreeNode n44 = new TreeNode(4);

        TreeNode n31 = new TreeNode(6);
        TreeNode n32 = new TreeNode(2);
        n32.left = n43; n32.right = n44;
        TreeNode n33 = new TreeNode(0);
        TreeNode n34 = new TreeNode(8);

        TreeNode n21 = new TreeNode(5);
        n21.left = n31; n21.right = n32;
        TreeNode n22 = new TreeNode(1);
        n22.left = n33; n22.right = n34;

        TreeNode n11 = new TreeNode(3);
        n11.left = n21; n11.right = n22;

        assertEquals(n21, new Solution236().lowestCommonAncestor(n11, n21, n44));
    }

    @Test
    public void lowestCommonAncestor_3() {
        TreeNode n43 = new TreeNode(7);
        TreeNode n44 = new TreeNode(4);

        TreeNode n31 = new TreeNode(6);
        TreeNode n32 = new TreeNode(2);
        n32.left = n43; n32.right = n44;
        TreeNode n33 = new TreeNode(0);
        TreeNode n34 = new TreeNode(8);

        TreeNode n21 = new TreeNode(5);
        n21.left = n31; n21.right = n32;
        TreeNode n22 = new TreeNode(1);
        n22.left = n33; n22.right = n34;

        TreeNode n11 = new TreeNode(3);
        n11.left = n21; n11.right = n22;

        assertEquals(n11, new Solution236().lowestCommonAncestor(n11, n33, n43));
    }

    @Test
    public void lowestCommonAncestor_4() {
        TreeNode n43 = new TreeNode(7);
        TreeNode n44 = new TreeNode(4);

        TreeNode n31 = new TreeNode(6);
        TreeNode n32 = new TreeNode(2);
        n32.left = n43; n32.right = n44;
        TreeNode n33 = new TreeNode(0);
        TreeNode n34 = new TreeNode(8);

        TreeNode n21 = new TreeNode(5);
        n21.left = n31; n21.right = n32;
        TreeNode n22 = new TreeNode(1);
        n22.left = n33; n22.right = n34;

        TreeNode n11 = new TreeNode(3);
        n11.left = n21; n11.right = n22;

        assertEquals(n22, new Solution236().lowestCommonAncestor(n11, n22, n34));
    }
}