package leetcode.LC_743;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 743. Network Delay Time
 */
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        // Parse `times` input into a map index and a graph
        Map<Integer, Node> nodes = new HashMap<>(N);
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0], v = times[i][1], w = times[i][2];

            Node uu = nodes.getOrDefault(u, new Node(u));
            Node vv = nodes.getOrDefault(v, new Node(v));
            uu.addChild(vv, w);
            nodes.put(u, uu);
            nodes.put(v, vv);
        }

        if (nodes.size() < N)
            return -1;

        // Perform a graph traversal starting from node w/ ID `K`
        final Node start = nodes.get(K);
        if (start == null)
            return -1;

        // Maintain 2 queues to organize the traversal
        Deque<Node> queue1 = new LinkedList<>();
        Deque<Integer> queue2 = new LinkedList<>();
        queue1.offer(start);
        queue2.offer(0);

        // Memorize visited ones' shortest times
        Map<Node, Integer> mins = new HashMap<>(N);
        mins.put(start, 0);

        // Actual traversal
        while (!queue1.isEmpty()) {
            final Node cur = queue1.poll();
            final int path = queue2.poll();

            for (Node child : cur.children.keySet()) {
                final int dist = path + cur.children.get(child);

                if (mins.getOrDefault(child, Integer.MAX_VALUE) <= dist)
                    continue;

                queue1.offer(child);
                queue2.offer(dist);
                mins.put(child, dist);
            }
        }

        // Collect result
        if (mins.size() < N)
            return -1;

        int min = 0;
        for (Node node : mins.keySet()) {
            final int dist = mins.get(node);
            if (dist > min)
                min = dist;
        }
        return min;
    }

    static class Node {
        final int id;
        final Map<Node, Integer> children;

        Node(int id) {
            this.id = id;
            this.children = new HashMap<>();
        }

        void addChild(Node child, int time) {
            this.children.put(child, time);
        }
    }
}

