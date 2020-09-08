package leetcode.LC_958;

import base.TreeNode;

import java.util.*;

/**
 * 958. Check Completeness of a Binary Tree
 *
 *
 *              1
 *          /      \
 *         2        3
 *       /  \      / \
 *      4    5    6  7
 *     / \  /
 *    8  9 10
 */
public class Solution958 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null)
            return false;

        int counter = 1;    // The node ID we are expecting

        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> idQ = new LinkedList<>();
        nodeQ.offer(root);
        idQ.offer(1);

        while (!nodeQ.isEmpty()) {
            TreeNode node = nodeQ.poll();
            Integer id = idQ.poll();

            if (id != counter++)    // Don't forget to increment `counter` by one!
                return false;

            if (node.left != null) {
                nodeQ.offer(node.left);
                idQ.offer(id * 2);
            }

            if (node.right != null) {
                nodeQ.offer(node.right);
                idQ.offer(id * 2 + 1);
            }
        }

        return true;
    }
}
