package leetcode.LC_114;

import base.TreeNode;

/**
 * 114. Flatten Binary Tree to Linked List
 */
class Solution114 {
    void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode mostr = root.left;
                while (mostr.right != null)
                    mostr = mostr.right;
                mostr.right = root.right;
                root.right = root.left;
                root.left = null;
            }

            root = root.right;
        }
    }

    /**
     *
     *
     *
     *
     *
     *
     *
     *
     */

    void flattenRecur(TreeNode root) {
        helper(root);
    }

    TreeNode[] helper(TreeNode node) {
        if (node == null)
            return null;

        TreeNode[] lefts = helper(node.left);
        TreeNode[] rights = helper(node.right);

        TreeNode tail = node;
        if (lefts != null) {
            tail.left = null;
            tail.right = lefts[0];
            tail = lefts[1];
        }
        if (rights != null) {
            tail.right = rights[0];
            tail = rights[1];
        }
        return new TreeNode[]{node, tail};
    }

    /**
     * A different recursive implementation
     * @param node
     * @return
     */
    private TreeNode helper2(TreeNode node) {
        // Handle the null scenario
        if (node == null)
            return null;

        // For a leaf node, we simply return the node as is.
        if (node.left == null && node.right == null)
            return node;

        //Recursively flatten the left subtree
        TreeNode leftTail = this.helper2(node.left);

        // Recursively flatten the right subtree
        TreeNode rightTail = this.helper2(node.right);

        // If there was a left subtree, we shuffle the connections around,
        // so that there is nothing on the left side anymore.
        if (leftTail != null) {
            leftTail.right = node.right;

            node.right = node.left;

            node.left = null;
        }

        // We need to return the "rightmost" node after we are
        // done wiring the new connections.
        return rightTail == null ? leftTail : rightTail;
    }
}
