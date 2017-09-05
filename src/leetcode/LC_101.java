package leetcode;

import base.TreeNode;

import java.util.Stack;

/**
 * Created by naco_siren on 7/30/17.
 */
public class LC_101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        LC_101 lc = new LC_101();
        lc.isSymmetric(root);

        return;
    }





    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<Pair> stack = new Stack<>();
        stack.push(pair(root.left, root.right));

        while (stack.isEmpty() == false) {
            Pair pair = stack.pop();
            TreeNode left = pair.left;
            TreeNode right = pair.right;

            if (left == null && right == null)
                continue;
            if (left == null || right == null)
                return false;
            if (left.val != right.val)
                return false;
            else {
                stack.push(pair(left.left, right.right));
                stack.push(pair(left.right, right.left));
            }
        }
        return true;
    }

    private Pair pair (TreeNode left, TreeNode right) {
        return new Pair(left, right);
    }

    class Pair {
        public TreeNode left;
        public TreeNode right;
        public Pair(TreeNode left, TreeNode right) {
            this.left = left;
            this.right = right;
        }
    }
}
