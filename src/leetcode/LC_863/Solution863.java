package leetcode.LC_863;

import base.TreeNode;

import java.util.*;

/**
 * 863. All Nodes Distance K in Binary Tree
 */
class Solution863 {
    List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> results = new ArrayList<>();

        // DFS to build parent map
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        TreeNode sentinel = new TreeNode(Integer.MIN_VALUE);
        dfs(root, sentinel, parents);

        // BFS from target
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> distQ = new LinkedList<>();
        nodeQ.offer(target);
        distQ.offer(0);

        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);
        seen.add(sentinel);

        while (!nodeQ.isEmpty()) {
            final TreeNode node = nodeQ.poll();
            final int dist = distQ.poll();
            if (dist == K)
                results.add(node.val);

            // 1. Parent
            TreeNode parent = parents.get(node);
            if (parent != null && !seen.contains(parent)) {
                seen.add(parent);
                nodeQ.offer(parent);
                distQ.offer(dist + 1);
            }

            // 2. Left child
            if (node.left != null && !seen.contains(node.left)) {
                seen.add(node.left);
                nodeQ.offer(node.left);
                distQ.offer(dist + 1);
            }

            // 3. Right child
            if (node.right != null && !seen.contains(node.right)) {
                seen.add(node.right);
                nodeQ.offer(node.right);
                distQ.offer(dist + 1);
            }
        }
        return results;
    }

    private void dfs(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parents) {
        if (node == null)
            return;

        parents.put(node, parent);
        dfs(node.left, node, parents);
        dfs(node.right, node, parents);
    }
}
