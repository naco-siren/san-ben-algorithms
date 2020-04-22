package leetcode.LC_560;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void subarraySum_0() {
        assertEquals(0, new Solution().subarraySum(new int[]{}, 0));
    }

    @Test
    public void subarraySum_1() {
        assertEquals(1, new Solution().subarraySum(new int[]{0}, 0));
    }

    @Test
    public void subarraySum_2() {
        assertEquals(3, new Solution().subarraySum(new int[]{0, 0}, 0));
        assertEquals(6, new Solution().subarraySum(new int[]{0, 0, 0}, 0));
    }

    @Test
    public void subarraySum_3() {
        assertEquals(4, new Solution().subarraySum(new int[]{1, 0, 1}, 1));
        assertEquals(3, new Solution().subarraySum(new int[]{1, -1, 1}, 1));
        assertEquals(2, new Solution().subarraySum(new int[]{1, -1, 1}, 0));
    }
}