package leetcode.LC_743;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void networkDelayTime_1() {
        assertEquals(2, new Solution().networkDelayTime(new int[][]{
                new int[]{2, 1, 1},
                new int[]{2, 3, 1},
                new int[]{3, 4, 1}
        }, 4, 2));
    }

    @Test
    public void networkDelayTime_2() {
        assertEquals(3, new Solution().networkDelayTime(new int[][]{
                new int[]{1, 2, 1},
                new int[]{2, 3, 2},
                new int[]{1, 3, 4}
        }, 3, 1));
    }
}