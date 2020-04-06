package leetcode.LC_122;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void maxProfit_1() {
        assertEquals(7, new Solution().maxProfit(new int[]{7,1,5,3,6,4}));
    }

    @Test
    public void maxProfit_2() {
        assertEquals(4, new Solution().maxProfit(new int[]{1,2,3,4,5}));
    }

    @Test
    public void maxProfit_3() {
        assertEquals(0, new Solution().maxProfit(new int[]{7,6,4,3,1}));
    }

    @Test
    public void maxProfit_4() {
        assertEquals(8, new Solution().maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
}