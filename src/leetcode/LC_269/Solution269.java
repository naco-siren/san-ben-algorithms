package leetcode.LC_269;

import java.util.*;

/**
 * 269. Alien Dictionary
 */
public class Solution269 {
    String alienOrder(String[] words) {
        // Adding all characters into a map
        Map<Character, Node> nodes = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                final char ch = word.charAt(i);
                if (!nodes.containsKey(ch))
                    nodes.put(ch, new Node(ch));
            }
        }

        // Topological sort with a map of in-degrees
        Map<Node, Integer> indegrees = new HashMap<>();

        // Derive pairs in order by comparing word after word
        for (int i = 1; i < words.length; i++) {
            char[] pair = deriveCharPair(words[i - 1], words[i]);
            if (pair == null)
                return "";

            if (pair.length == 0)
                continue;

            Node first = nodes.getOrDefault(pair[0], new Node(pair[0]));
            Node second = nodes.getOrDefault(pair[1], new Node(pair[1]));

            if (first.addChild(second))
                indegrees.put(second, indegrees.getOrDefault(second, 0) + 1);

            nodes.put(pair[0], first);
            nodes.put(pair[1], second);
        }

        List<Node> order = extractTopologicalOrder(nodes, indegrees);

        StringBuilder builder = new StringBuilder();
        for (Node node : order)
            builder.append(node.value);
        return builder.toString();
    }

    char[] deriveCharPair(final String first, final String second) {
        int i = 0;
        for (; i < Math.min(first.length(), second.length()); i++) {
            final char ch1 = first.charAt(i), ch2 = second.charAt(i);
            if (ch1 == ch2)
                continue;
            return new char[]{ch1, ch2};
        }

        if (i == first.length())
            return new char[]{};
        else
            return null;
    }

    /**
     * Extract topological order of the characters from indegress map
     * @param nodes
     * @param indegrees
     * @return
     */
    List<Node> extractTopologicalOrder(Map<Character, Node> nodes, Map<Node, Integer> indegrees) {
        // Find all 0-degree nodes
        Queue<Node> queue = new LinkedList<>();
        for (Map.Entry<Character, Node> entry : nodes.entrySet()) {
            final Node node = entry.getValue();
            if (!indegrees.containsKey(node))
                queue.offer(node);
        }

        // There must be at least one zero in-degree node
        final List<Node> order = new ArrayList<>();
        if (queue.isEmpty())
            return order;

        // Perform topological sort
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            order.add(node);

            for (Node child : node.children) {
                Integer indegree = indegrees.get(child);
                if (indegree == 1)
                    queue.offer(child);
                indegrees.put(child, indegree - 1);
            }
        }

        // All nodes' in-degrees must be distinct
        if (order.size() != nodes.size())
            return new LinkedList<>();
        return order;
    }

    static class Node {
        final char value;
        final Set<Node> children;

        Node(char value) {
            this.value = value;
            this.children = new HashSet<>();
        }

        boolean addChild(Node node) {
            if (children.contains(node)) {
                return false;
            } else {
                children.add(node);
                return true;
            }
        }

        @Override
        public String toString() {
            return "[" + value + "]";
        }
    }
}
