package leetcode.LC_152;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution152Test {

    @Test
    public void maxProduct_0() {
        assertEquals(0, new Solution152().maxProduct(new int[]{}));
    }

    @Test
    public void maxProduct_1() {
        assertEquals(1, new Solution152().maxProduct(new int[]{1}));
        assertEquals(-1, new Solution152().maxProduct(new int[]{-1}));
    }

    @Test
    public void maxProduct_2() {
        assertEquals(24, new Solution152().maxProduct(new int[]{2, 3, 4}));
        assertEquals(4, new Solution152().maxProduct(new int[]{2, -3, 4}));
        assertEquals(0, new Solution152().maxProduct(new int[]{-2, 0, -1}));
        assertEquals(24, new Solution152().maxProduct(new int[]{-2,3,-4}));
    }

    @Test
    public void maxProduct_3n() {
        assertEquals(12, new Solution152().maxProduct(new int[]{-4, -3, -2}));
    }

    @Test
    public void maxProduct_4() {
        assertEquals(6, new Solution152().maxProduct(new int[]{2,3,-2,4}));
    }

    @Test
    public void maxProduct_5() {
        assertEquals(24, new Solution152().maxProduct(new int[]{2,-5,-2,-4,3}));
    }

}