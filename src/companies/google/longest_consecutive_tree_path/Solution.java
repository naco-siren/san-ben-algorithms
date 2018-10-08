package companies.google.longest_consecutive_tree_path;

import java.util.*;

public class Solution {
    static class Node {
        int val;
        ArrayList<Node> children;

        public Node(int val){
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Node n00 = new Node(3);

        Node n10 = new Node(4); n00.children.add(n10);
        Node n11 = new Node(5); n00.children.add(n11);
        Node n12 = new Node(6); n00.children.add(n12);

        Node n20 = new Node(1); n10.children.add(n20);
        Node n21 = new Node(2); n11.children.add(n21);
        Node n22 = new Node(6); n11.children.add(n22);
        Node n23 = new Node(7); n11.children.add(n23);
        Node n24 = new Node(0); n12.children.add(n24);

        Node n30 = new Node(4); n22.children.add(n30);
        Node n31 = new Node(7); n22.children.add(n31);
        Node n32 = new Node(5); n23.children.add(n32);
        Node n33 = new Node(8); n23.children.add(n33);

        Node n40 = new Node(1); n31.children.add(n40);
        Node n41 = new Node(9); n33.children.add(n41);

        List<Node> r1 = new Solution().solve(n00); // [7, 8, 9]

        return;
    }


    public static List<Node> solve(Node root) {
        int maxLen = 0;
        List<Node> maxPath = null;

        Stack<Node> nodes = new Stack<>();
        Stack<ArrayList<Node>> paths = new Stack<>();

        nodes.add(root);
        paths.add(new ArrayList<>());

        // Perform DFS
        while (nodes.isEmpty() == false) {
            Node node = nodes.pop();
            ArrayList<Node> path = paths.pop();
            path.add(node);

            // Update max record
            if (path.size() > maxLen) {
                maxLen = path.size();
                maxPath = new ArrayList<>(path);
            }

            // DFS
            for (Node child : node.children) {
                if (child.val == node.val + 1) {
                    nodes.add(child);
                    paths.add(new ArrayList<>(path));

                } else {
                    nodes.add(child);
                    paths.add(new ArrayList<>());

                }
            }

        }
        return maxPath;
    }

}
