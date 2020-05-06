package leetcode.LC_102;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
class Solution102 {
    List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();

        // Perform a BFS
        Queue<TreeNode> thisRow = new LinkedList<>();
        if (root != null)
            thisRow.offer(root);

        // Poll all nodes on this row and then offer their children to next row
        while (!thisRow.isEmpty()) {
            List<Integer> result = new ArrayList<>(thisRow.size());
            Queue<TreeNode> nextRow = new LinkedList<>();

            while (!thisRow.isEmpty()) {
                TreeNode node = thisRow.poll();
                result.add(node.val);

                if (node.left != null)
                    nextRow.offer(node.left);
                if (node.right != null)
                    nextRow.offer(node.right);
            }

            results.add(result);
            thisRow = nextRow;
        }
        return results;
    }
}
