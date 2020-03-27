package leetcode.LC_951;

import base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 951. Flip Equivalent Binary Trees
 */
public class Solution {
    public boolean flipEquivRecur(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        } else if (root1 != null && root2 == null) {
            return false;
        } else if (root1 == null) {
            return false;
        } else {
            final boolean o = flipEquivRecur(root1.left, root2.left) && flipEquivRecur(root1.right, root2.right);
            final boolean s = flipEquivRecur(root1.left, root2.right) && flipEquivRecur(root1.right, root2.left);
            return root1.val == root2.val && (o || s);
        }
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // Initialize two deques
        Deque<TreeNode> q1 = new LinkedList<>();
        Deque<TreeNode> q2 = new LinkedList<>();
        q1.offer(root1);
        q2.offer(root2);

        // Keep polling from the deques to check each pair's values & children
        while (!q1.isEmpty()) {
            final TreeNode n1 = q1.poll(), n2 = q2.poll();
            if (root1 == null && root2 == null) {
                continue;
            } else if (root1 != null && root2 == null) {
                return false;
            } else if (root1 == null && root2 != null) {
                return false;
            } else if (root1.val != root2.val) {
                return false;
            }

            final TreeNode l1 = n1.left, r1 = n1.right;
            final TreeNode l2 = n2.left, r2 = n2.right;

            final TreeNode[] s = isSymmetrical(l1, r1, l2, r2);
            if (s == null) {
                return false;
            } else if (s.length == 0) {
                continue;
            } else if (s.length == 2) {
                q1.offer(s[0]);
                q2.offer(s[1]);
            } else {
                q1.offer(s[0]);
                q2.offer(s[1]);
                q1.offer(s[2]);
                q2.offer(s[3]);
            }
        }
        return true;
    }

    private TreeNode[] isSymmetrical(TreeNode l1, TreeNode r1, TreeNode l2, TreeNode r2) {
        if (l1 == null && r1 == null && l2 == null && r2 == null) {
            return new TreeNode[0];

        } else if (l1 != null && r1 == null && l2 != null && r2 == null) {
            if (l1.val == l2.val) {
                TreeNode[] ts = new TreeNode[2];
                ts[0] = l1; ts[1] = l2;
                return ts;
            } else {
                return null;
            }
        } else if (l1 != null && r1 == null && l2 == null && r2 != null) {
            if (l1.val == r2.val) {
                TreeNode[] ts = new TreeNode[2];
                ts[0] = l1; ts[1] = r2;
                return ts;
            } else {
                return null;
            }
        } else if (l1 == null && r1 != null && l2 != null && r2 == null) {
            if (r1.val == l2.val) {
                TreeNode[] ts = new TreeNode[2];
                ts[0] = r1; ts[1] = l2;
                return ts;
            } else {
                return null;
            }
        } else if (l1 == null && r1 != null && l2 == null && r2 != null) {
            if (r1.val == r2.val) {
                TreeNode[] ts = new TreeNode[2];
                ts[0] = r1; ts[1] = r2;
                return ts;
            } else {
                return null;
            }
        } else if (l1 != null && r1 != null && l2 != null && r2 != null) {
            if (l1.val == l2.val) {
                if (r1.val == r2.val) {
                    TreeNode[] ts = new TreeNode[4];
                    ts[0] = l1; ts[1] = l2; ts[2] = r1; ts[3] = r2;
                    return ts;
                } else {
                    return null;
                }
            } else {
                if (l1.val == r2.val) {
                    TreeNode[] ts = new TreeNode[4];
                    ts[0] = l1; ts[1] = r2; ts[2] = r1; ts[3] = l2;
                    return ts;
                } else {
                    return null;
                }
            }
        } else {
            return null;
        }
    }
}
