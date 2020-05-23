package leetcode.LC_114;

import base.TreeNode;

/**
 * 114. Flatten Binary Tree to Linked List
 */
class Solution114 {
    /**
     * Step 1.
     *       (1)        tail:       1
     *      /  \        rightMost:  4
     *     2    5.
     *   / \     \
     *  3   <4>   6
     *
     * Step 2.
     *       (1)        tail:       1
     *      /  \        rightMost:  4
     *     2    2
     *   / \   / \
     *  3   4 3  <4>
     *             \
     *              5.
     *               \
     *                6
     *
     * Step 3.
     *       (1)        tail:       1
     *         \        rightMost:  4
     *          2
     *         / \
     *        3  <4>
     *             \
     *              5.
     *               \
     *                6
     * Step 4.
     *        1         tail:       2
     *         \
     *         (2)
     *         / \
     *        3   4
     *             \
     *              5
     *               \
     *                6
     *
     *
     */
    void flatten(TreeNode root) {
        TreeNode tail = root;
        while (tail != null) {
            if (tail.left != null) {
                // 1. Find the right-most node of tail's left
                TreeNode rightMost = tail.left;
                while (rightMost.right != null)
                    rightMost = rightMost.right;

                // 2. Insert [tail.left -> ... -> rightMost] in between `tail` and `tail.right`
                rightMost.right = tail.right;
                tail.right = tail.left;

                // 3. Cut off from tail's left
                tail.left = null;
            }

            // 4. Move `tail` one step down on the right
            tail = tail.right;
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
