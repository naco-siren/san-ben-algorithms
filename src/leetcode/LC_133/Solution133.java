package leetcode.LC_133;

import java.util.*;

/**
 * 133. Clone Graph
 */
class Solution133 {
    Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return clone(node, map);
    }

    private Node clone(Node node, Map<Node, Node> map) {
        if (node == null)
            return null;

        Node cloned = map.get(node);
        if (cloned != null)         // DISCUSS IF CONTAINS, DO NOT USE `getOrDefault` FOR THIS CASE
            return cloned;

        cloned = new Node(node.val);
        map.put(node, cloned);      // NOTE THAT WE UPDATE MAP BEFORE RECURSION

        for (Node neighbor : node.neighbors)
            cloned.neighbors.add(clone(neighbor, map));

        return cloned;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
