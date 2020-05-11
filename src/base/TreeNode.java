package base;

/**
 * Created by naco_siren on 7/30/17.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "[" + val + "] -> (" + (left != null ? left.val : null) + ", " + (right != null ? right.val : null) + ")";
    }
}
