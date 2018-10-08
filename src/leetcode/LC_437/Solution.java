package leetcode.LC_437;

import base.TreeNode;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode n00 = new TreeNode(10);

        TreeNode n10 = new TreeNode(5);
        TreeNode n11 = new TreeNode(-3);
        n00.left = n10; n00.right = n11;

        TreeNode n20 = new TreeNode(3);
        TreeNode n21 = new TreeNode(2);
        TreeNode n23 = new TreeNode(11);
        n10.left = n20; n10.right = n21; n11.right = n23;

        TreeNode n30 = new TreeNode(3);
        TreeNode n31 = new TreeNode(-2);
        TreeNode n33 = new TreeNode(1);
        n20.left = n30; n20.right = n31; n21.right = n33;

        //
        //        10
        //       /  \
        //      5   -3
        //    / \    \
        //   3   2   11
        //  / \   \
        // 3  -2   1

        int r1 = solution.pathSum(n00, 8);  // 3
        int r2 = solution.pathSum(n00, 6);  // 2
    }

    Solution() {

    }

    int result = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        dfs(root, sum);
        if (root.left != null) pathSum(root.left, sum);
        if (root.right != null) pathSum(root.right, sum);

        return result;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) return;

        if (root.val == sum)
            result++;

        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
    }
}
