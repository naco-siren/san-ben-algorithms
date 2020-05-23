package leetcode.LC_098;

import base.TreeNode;

/**
 * 98. Validate Binary Search Tree
 */
class Solution98 {
    boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null)
            return true;

        if (lower != null && node.val <= lower)
            return false;
        if (upper != null && node.val >= upper)
            return false;

        boolean left = helper(node.left, lower, node.val);
        boolean right = helper(node.right, node.val, upper);
        return left && right;
    }
}
