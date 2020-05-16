package leetcode.LC_637;

import base.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 637. Average of Levels in Binary Tree
 */
class Solution637 {
    private Map<Integer, Double> levelSums = new HashMap<>();
    private Map<Integer, Integer> levelCounts = new HashMap<>();

    List<Double> averageOfLevels(TreeNode root) {
        final int maxDepth = traverse(root, 0);

        List<Double> output = new ArrayList<>();
        for (int i = 0; i < maxDepth; i++) {
            double sum = levelSums.get(i);
            double count = (double) levelCounts.get(i);
            output.add(sum / count);
        }
        return output;
    }

    private int traverse(TreeNode root, int depth) {
        if (root == null)
            return 0;

        final int left = traverse(root.left, depth + 1);
        final int right = traverse(root.right, depth + 1);
        final int maxDepth = Math.max(left, right) + 1;

        levelSums.put(depth, levelSums.getOrDefault(depth, 0d) + root.val);
        levelCounts.put(depth, levelCounts.getOrDefault(depth, 0) + 1);

        return maxDepth;
    }
}