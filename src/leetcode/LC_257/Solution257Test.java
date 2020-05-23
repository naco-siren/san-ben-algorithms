package leetcode.LC_257;

import base.TreeNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class Solution257Test {

    @Test
    public void binaryTreePaths_1_2_3_null_5_null_null() {
        TreeNode n32 = new TreeNode(5);
        TreeNode n21 = new TreeNode(2); n21.right = n32;
        TreeNode n22 = new TreeNode(3);
        TreeNode n11 = new TreeNode(1); n11.left = n21; n11.right = n22;

        List<String> result = new Solution257().binaryTreePaths(n11);
        Set<String> resultSet = new HashSet<>(result);

        Set<String> expected = new HashSet<>();
        expected.add("1->2->5");
        expected.add("1->3");

        assertEquals(expected, resultSet);
    }
}