package leetcode.LC_975;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void oddEvenJumps_0() {
        assertEquals(0, new Solution().oddEvenJumps(new int[]{}));
    }

    @Test
    public void oddEvenJumps_1() {
        assertEquals(2, new Solution().oddEvenJumps(new int[]{1,3,2,4,5}));
    }

    @Test
    public void oddEvenJumps_3() {
        assertEquals(3, new Solution().oddEvenJumps(new int[]{2,3,1,1,4}));
    }

    @Test
    public void oddEvenJumps_4() {
        assertEquals(3, new Solution().oddEvenJumps(new int[]{5,1,3,4,2}));
    }
}