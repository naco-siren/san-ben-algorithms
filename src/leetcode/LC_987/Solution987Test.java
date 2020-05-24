package leetcode.LC_987;

import base.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution987Test {

    @Test
    public void verticalTraversal_0_8_1_null_null_3_2_null_4_5_null_null_7_6() {
        TreeNode n51 = new TreeNode(7);
        TreeNode n52 = new TreeNode(6);
        TreeNode n41 = new TreeNode(4); n41.right = n51;
        TreeNode n42 = new TreeNode(5); n42.left = n52;
        TreeNode n31 = new TreeNode(3); n31.right = n41;
        TreeNode n32 = new TreeNode(2); n32.left = n42;
        TreeNode n21 = new TreeNode(8);
        TreeNode n22 = new TreeNode(1); n22.left = n31; n22.right = n32;
        TreeNode n11 = new TreeNode(0); n11.left = n21; n11.right = n22;

        List<List<Integer>> result = new Solution987().verticalTraversal(n11);
        
        Integer[][] expected = new Integer[][]{
                {8},{0,3,6},{1,4,5},{2,7}
        };
        
        assertEquals(expected.length, result.size());
        for (int i = 0; i < expected.length; i++) {
            Integer[] exp = new Integer[expected[i].length];
            assertArrayEquals(expected[i], result.get(i).toArray(exp));
        }
    }
    
    @Test
    public void verticalTraversal_0_2_1_3_null_null_null_4_5_null_7_6_null_10_8_11_9() {
        TreeNode n61 = new TreeNode(10);
        TreeNode n62 = new TreeNode(8);
        TreeNode n63 = new TreeNode(11);
        TreeNode n64 = new TreeNode(9);
        TreeNode n51 = new TreeNode(7); n51.left = n61; n51.right = n62;
        TreeNode n52 = new TreeNode(6); n52.left = n63; n52.right = n64;
        TreeNode n41 = new TreeNode(4); n41.right = n51;
        TreeNode n42 = new TreeNode(5); n42.left = n52;
        TreeNode n31 = new TreeNode(3); n31.left = n41; n31.right = n42;
        TreeNode n21 = new TreeNode(2); n21.left = n31;
        TreeNode n22 = new TreeNode(1);
        TreeNode n11 = new TreeNode(0); n11.left = n21; n11.right = n22;

        List<List<Integer>> result = new Solution987().verticalTraversal(n11);

        Integer[][] expected = new Integer[][]{
                {4,10,11},{3,6,7},{2,5,8,9},{0},{1}
        };

        assertEquals(expected.length, result.size());
        for (int i = 0; i < expected.length; i++) {
            Integer[] exp = new Integer[expected[i].length];
            assertArrayEquals(expected[i], result.get(i).toArray(exp));
        }
    }
}