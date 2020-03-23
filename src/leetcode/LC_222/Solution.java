package leetcode.LC_222;

import base.TreeNode;

/**
 * 222. Count Complete Tree Nodes
 */
public class Solution {
    public static int countNodes(TreeNode root) {
        // Get tree height
        int height = 0;
        TreeNode cur = root;
        while (cur != null) {
            height++;
            cur = cur.left;
        }

        // Exclude a fully-grown tree
        int height2 = 0;
        cur = root;
        while (cur != null) {
            height2++;
            cur = cur.right;
        }
        if (height2 == height)
            return (int) Math.pow(2, height) - 1;

        // Binary search to locate last level position
        cur = root;
        int lefts = 0;
        for (int remains = height - 1; remains > 0; remains--) {
            TreeNode iter = cur.left;
            // Find the right-most leaf on the sub-tree
            for (int i = remains - 1; i > 0; i--)
                iter = iter.right;

            // Offset lefts
            if (iter != null) {
                cur = cur.right;
                lefts += Math.pow(2, remains - 1);
            } else {
                cur = cur.left;
            }
        }

        return ((int) Math.pow(2, height - 1)) - 1 + lefts;
    }
}
