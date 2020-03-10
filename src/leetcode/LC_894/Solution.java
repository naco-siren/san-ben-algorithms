package leetcode.LC_894;

import base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 894. All Possible Full Binary Trees
 *
 * A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 *
 * Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.
 *
 * Each node of each tree in the answer must have node.val = 0.
 *
 * You may return the final list of trees in any order.
 *
 *
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<TreeNode> allPossibleFBT(int N) {
        // Init dynamic programming cache
        HashMap<Integer, List<TreeNode>> dp = new HashMap<>();
        dp.put(0, new ArrayList<>());

        List<TreeNode> single = new ArrayList<>();
        single.add(new TreeNode(0));
        dp.put(1, single);

        // Depth-first search
        List<TreeNode> results = dfs(N, dp);
        return results;
    }

    private List<TreeNode> dfs(int remains, HashMap<Integer, List<TreeNode>> dp) {
        // Fetch from DP cache
        if (dp.containsKey(remains))
            return dp.get(remains);

        // Another DFS with DP
        List<TreeNode> results = new ArrayList<>();
        for (int i = 1; i < remains - 1; i++) {
            // Left node
            List<TreeNode> left;
            if (!dp.containsKey(i)) {
                left = dfs(i, dp);
                dp.put(i, left);
            } else {
                left = dp.get(i);
            }

            // Right node
            int j = remains - 1 - i;
            List<TreeNode> right;
            if (!dp.containsKey(j)) {
                right = dfs(j, dp);
                dp.put(j, right);
            } else {
                right = dp.get(j);
            }

            // Early continue on empty list
            if (left.isEmpty() || right.isEmpty()) {
                continue;
            }

            // Combine them and add to results
            List<TreeNode> result = combine(left, right);
            results.addAll(result);
        }

        // DP caching
        if (results.isEmpty()) {
            dp.put(remains, results);
        }

        return results;
    }

    private List<TreeNode> combine(List<TreeNode> left, List<TreeNode> right) {
        List<TreeNode> nodes = new ArrayList<>();
        for (TreeNode l : left) {
            for (TreeNode r : right) {
                TreeNode clone = new TreeNode(0);
                clone.left = l;
                clone.right = r;
                nodes.add(clone);
            }
        }
        return nodes;
    }
}