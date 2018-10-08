package leetcode.LC_437;

import base.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class FollowUp {
    public static void main(String[] args) {
        FollowUp solution = new FollowUp();

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

        List<List<Integer>> r1 = solution.pathSum(n00, 8);
        //  5 -> 3
        //  5 -> 2 -> 1
        // -3 -> 11

        List<List<Integer>> r2 = solution.pathSum(n00, 6);
        // 5 -> 3 -> -2
        // 3 -> 3
    }

    List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new LinkedList<>();
        if (root == null)
            return results;

        LinkedList<Integer> prefix = new LinkedList<>();
        dfs(root, sum, prefix, results);

        List<List<Integer>> resultsL = pathSum(root.left, sum);
        List<List<Integer>> resultsR = pathSum(root.right, sum);

        results.addAll(resultsL);
        results.addAll(resultsR);
        return results;
    }

    private void dfs(TreeNode node, int sum, LinkedList<Integer> prefix, List<List<Integer>> results) {
        if (node == null)
            return;

        prefix.add(node.val);
        if (node.val == sum)
            results.add(new LinkedList<>(prefix));

        dfs(node.left, sum - node.val, prefix, results);
        dfs(node.right, sum - node.val, prefix, results);

        prefix.removeLast();
    }
}
