package algorithm.topological_sort;

import base.DirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by naco_siren on 8/18/17.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        return;
    }

    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<>();

        /* HashMap: Node -> in-degrees */
        HashMap<DirectedGraphNode, Integer> map = new HashMap();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }

        /* Instantiate a queue with nodes of zero in-degrees */
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            if (map.containsKey(node) == false) {
                queue.offer(node);
                result.add(node);
            }
        }

        /* Process the nodes in the queue one by one */
        while (queue.isEmpty() == false) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode n : node.neighbors) {
                map.put(n, map.get(n) - 1);

                /* If in-degree is zero, add to queue */
                if (map.get(n) == 0) {
                    result.add(n);
                    queue.offer(n);
                }
            }
        }
        return result;
    }
}
