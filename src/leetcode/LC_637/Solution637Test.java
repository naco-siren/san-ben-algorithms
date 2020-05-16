package leetcode.LC_637;

import base.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution637Test {

    @Test
    public void averageOfLevels_1() {
        /*
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         */

        TreeNode n31 = new TreeNode(15);
        TreeNode n32 = new TreeNode(7);
        TreeNode n21 = new TreeNode(9);
        TreeNode n22 = new TreeNode(20);
        n22.left = n31; n22.right = n32;
        TreeNode n1 = new TreeNode(3);
        n1.left = n21;  n1.right = n22;
        List<Double> result = new Solution637().averageOfLevels(n1);
        assertEquals(result.size(), 3);
        assertEquals(result.get(0), new Double(3));
        assertEquals(result.get(1), new Double(14.5d));
        assertEquals(result.get(2), new Double(11));
    }

    @Test
    public void averageOfLevels_overflow() {
        /*
         *      MAX
         *     /  \
         *   MAX  MAX
         */

        TreeNode n21 = new TreeNode(Integer.MAX_VALUE);
        TreeNode n22 = new TreeNode(Integer.MAX_VALUE);
        TreeNode n1 = new TreeNode(Integer.MAX_VALUE);
        n1.left = n21;  n1.right = n22;
        List<Double> result = new Solution637().averageOfLevels(n1);
        assertEquals(result.size(), 2);
        assertEquals(result.get(0), new Double(Integer.MAX_VALUE));
        assertEquals(result.get(1), new Double(Integer.MAX_VALUE));
    }
}