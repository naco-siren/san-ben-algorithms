package base;

/**
 * Created by naco_siren on 8/18/17.
 */

import java.util.ArrayList;

/**
 * Definition for Directed graph.
 */
public class DirectedGraphNode {
    public int label;
    public ArrayList<DirectedGraphNode> neighbors;

    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}
