package companies.google.xml_encode_tree;

import java.util.ArrayList;

/**
 * Created by naco_siren on 10/17/17.
 */
public class TreeNode {
    String val;
    ArrayList<TreeNode> children;

    public TreeNode(String val) {
        this.val = val;
        this.children = new ArrayList<>();
    }
}
