package leetcode.LC_201;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void rangeBitwiseAnd_0() {
        assertEquals(0, new Solution().rangeBitwiseAnd(0, 0));
        assertEquals(0, new Solution().rangeBitwiseAnd(0, 1));
    }

    @Test
    public void rangeBitwiseAnd_1() {
        assertEquals(4, new Solution().rangeBitwiseAnd(5, 7));
    }

    @Test
    public void rangeBitwiseAnd_2() {
        assertEquals(6, new Solution().rangeBitwiseAnd(6, 7));
    }

    @Test
    public void rangeBitwiseAnd_3() {
        assertEquals(0, new Solution().rangeBitwiseAnd(3, 7));
        assertEquals(0, new Solution().rangeBitwiseAnd(2, 8));
        assertEquals(0, new Solution().rangeBitwiseAnd(2, 6));
        assertEquals(0, new Solution().rangeBitwiseAnd(2, 9));
    }
}