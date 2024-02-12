package leetcode.LC_666;

import java.util.*;

public class Solution666 {
    public int pathSum(int[] nums) {
        Queue<Node> nodes = new LinkedList<>();
        Node[][] tree = new Node[][]{
                new Node[1],
                new Node[2],
                new Node[4],
                new Node[8],
                new Node[16],
        };

        for (int num : nums) {
            int depth = num / 100;
            int position = (num - depth * 100) / 10;
            final int value = num - depth * 100 - position * 10;

            Node node = new Node(value);
            tree[--depth][--position] = node;   // Convert index to 0 based

            // find its parent
            if (depth > 0) {
                Node parent = tree[depth-1][position / 2];
                if ((position & 1) == 1) {
                    parent.right = node;
                } else {
                    parent.left = node;
                }
                node.parent = parent;
            }

            nodes.offer(node);
        }

        int totalPathSum = 0;
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            int pathSum = 0;
            if (node.left == null && node.right == null) {
                while (node != null) {
                    pathSum += node.value;
                    node = node.parent;
                }
            }
            totalPathSum += pathSum;
        }

        return totalPathSum;
    }

    private class Node {
        final int value;
        Node left;
        Node right;
        Node parent;

        private Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }
}
