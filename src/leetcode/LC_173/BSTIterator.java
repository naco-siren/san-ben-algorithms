package leetcode.LC_173;

import java.util.Stack;

/**
 * 173. Binary Search Tree Iterator
 */
class BSTIterator {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }




    TreeNode node;              // Pending right child. (its parent has been already visited)
    Stack<TreeNode> stack;      // Parent nodes, i.e. in-order.

    public BSTIterator(TreeNode root) {
        this.node = root;
        this.stack = new Stack<>();
    }

    /** @return the next smallest number */
    public int next() {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        node = stack.pop();
        int retVal = node.val;

        node = node.right;
        return retVal;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return node != null || !stack.isEmpty();
    }
}
