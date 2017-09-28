package leetcode.LC_101;

import base.TreeNode;

import java.util.Stack;

/**
 * Created by naco_siren on 7/30/17.
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        boolean r1 = isSymmetric(root1); // [False]


        TreeNode root2 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(4);
        root1.right.right = new TreeNode(4);
        boolean r2 = isSymmetric(root2); // [True]

        return;
    }



    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root.left);
        stack2.push(root.right);

        while (!stack1.isEmpty()) {
            TreeNode left = stack1.pop();
            TreeNode right = stack2.pop();

            if (left == null && right == null)
                continue;
            if (left == null || right == null)
                return false;
            if (left.val != right.val)
                return false;
            else {
                stack1.push(left.left);
                stack2.push(right.right);

                stack1.push(left.right);
                stack2.push(right.left);
            }
        }
        return true;
    }



}
