package leetcode.LC_1008;

import base.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void bstFromPreorder_1() {
        final TreeNode result = new Solution().bstFromPreorder(new int[]{5,1,7});

        assertEquals(5, result.val);
        assertNotNull(result.left);
        assertNotNull(result.right);
            assertEquals(1, result.left.val);
            assertNull(result.left.left);
            assertNull(result.left.right);
            assertEquals(7, result.right.val);
            assertNull(result.right.left);
            assertNull(result.right.right);
    }

    @Test
    public void bstFromPreorder_2() {
        final TreeNode result = new Solution().bstFromPreorder(new int[]{10,12});

        assertEquals(10, result.val);
        assertNull(result.left);
        assertNotNull(result.right);
            assertEquals(12, result.right.val);
            assertNull(result.right.left);
            assertNull(result.right.right);
    }

    @Test
    public void bstFromPreorder_3() {
        final TreeNode result = new Solution().bstFromPreorder(new int[]{10,9});

        assertEquals(10, result.val);
        assertNotNull(result.left);
        assertNull(result.right);
            assertEquals(9, result.left.val);
            assertNull(result.left.left);
            assertNull(result.left.right);
    }

    @Test
    public void bstFromPreorder_5() {
        final TreeNode result = new Solution().bstFromPreorder(new int[]{8,5,1,7,10,12});

        assertEquals(8, result.val);
        assertNotNull(result.left);
        assertNotNull(result.right);
            assertEquals(5, result.left.val);
            assertNotNull(result.left.left);
            assertNotNull(result.left.right);
                assertEquals(1, result.left.left.val);
                assertNull(result.left.left.left);
                assertNull(result.left.left.right);
                assertEquals(7, result.left.right.val);
                assertNull(result.left.right.left);
                assertNull(result.left.right.right);
            assertEquals(10, result.right.val);
            assertNull(result.right.left);
            assertNotNull(result.right.right);
                assertEquals(12, result.right.right.val);
                assertNull(result.right.right.left);
                assertNull(result.right.right.right);
    }
}