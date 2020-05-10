package leetcode.LC_297;

import base.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution297Test {

    @Test
    public void serialize_null() {
        Solution297 solution = new Solution297();

        TreeNode n1 = null;
        final String serialization = solution.serialize(n1);

        TreeNode r1 = solution.deserialize(serialization);
        assertNull(r1);
    }

    @Test
    public void serialize_single_val() {
        Solution297 solution = new Solution297();

        TreeNode n1 = new TreeNode(1);
        final String serialization = solution.serialize(n1);

        TreeNode r1 = solution.deserialize(serialization);
        assertEquals(1, r1.val);
        assertNull(r1.left);
        assertNull(r1.right);
    }

    @Test
    public void serialize_two_levels() {
        Solution297 solution = new Solution297();

        TreeNode n21 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        n1.left = n21;
        final String serialization = solution.serialize(n1);

        TreeNode r1 = solution.deserialize(serialization);
        assertEquals(1, r1.val);
        assertEquals(2, r1.left.val);
        assertNull(r1.left.left);
        assertNull(r1.left.right);
        assertNull(r1.right);
    }

    @Test
    public void serialize_two_levels_full() {
        Solution297 solution = new Solution297();

        TreeNode n21 = new TreeNode(2);
        TreeNode n22 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1);
        n1.left = n21;
        n1.right = n22;
        final String serialization = solution.serialize(n1);

        TreeNode r1 = solution.deserialize(serialization);
        assertEquals(1, r1.val);
        assertEquals(2, r1.left.val);
        assertEquals(3, r1.right.val);
        assertNull(r1.left.left);
        assertNull(r1.left.right);
        assertNull(r1.right.left);
        assertNull(r1.right.right);
    }


}