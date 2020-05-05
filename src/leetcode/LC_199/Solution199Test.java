package leetcode.LC_199;

import base.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution199Test {

    @Test
    public void rightSideView_0() {
        TreeNode n1 = new TreeNode(1);
        List<Integer> result = new Solution199().rightSideView(n1);

        assertEquals(1, result.size());
        assertEquals(1, (int) result.get(0));
    }

    @Test
    public void rightSideView_1() {
        // Input: [1,2,3,null,5,null,4]
        // Output: [1, 3, 4]
        // Explanation:
        //
        //    1            <---
        //  /   \
        // 2     3         <---
        //  \     \
        //   5     4       <---

        TreeNode n32 = new TreeNode(5);
        TreeNode n34 = new TreeNode(4);
        TreeNode n22 = new TreeNode(3); n22.right = n34;
        TreeNode n21 = new TreeNode(2); n21.right = n32;
        TreeNode n1 = new TreeNode(1);  n1.left = n21;  n1.right = n22;
        List<Integer> result = new Solution199().rightSideView(n1);

        assertEquals(3, result.size());
        assertEquals(1, (int) result.get(0));
        assertEquals(3, (int) result.get(1));
        assertEquals(4, (int) result.get(2));
    }

    @Test
    public void rightSideView_2() {
        // Input: [1,2,3,null,5,null,4]
        // Output: [1, 3, 4]
        // Explanation:
        //
        //    1            <---
        //  /   \
        // 2     3         <---
        //  \
        //   5             <---

        TreeNode n32 = new TreeNode(5);
        TreeNode n22 = new TreeNode(3);
        TreeNode n21 = new TreeNode(2); n21.right = n32;
        TreeNode n1 = new TreeNode(1);  n1.left = n21;  n1.right = n22;
        List<Integer> result = new Solution199().rightSideView(n1);

        assertEquals(3, result.size());
        assertEquals(1, (int) result.get(0));
        assertEquals(3, (int) result.get(1));
        assertEquals(5, (int) result.get(2));
    }
}