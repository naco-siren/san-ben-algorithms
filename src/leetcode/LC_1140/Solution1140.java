package leetcode.LC_1140;

import base.TreeNode;

/**
 * 1140. Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
 */
class Solution1140 {
    boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root, arr, 0);
    }

    private boolean dfs(TreeNode node, final int[] arr, final int index) {
        // Each node must match `arr`
        if (node != null && node.val == arr[index]) {
            if (index == arr.length - 1) {  // This branch guards that `index` will not out of boundary
                // Leaf node
                return node.left == null && node.right == null;
            } else {
                // Non-leaf node
                return dfs(node.left, arr, index + 1) || dfs(node.right, arr, index + 1);
            }
        }

        // Handles both `null` nodes and incorrect matches
        return false;
    }
}
