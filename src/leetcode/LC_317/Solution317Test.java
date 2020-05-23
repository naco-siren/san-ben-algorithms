package leetcode.LC_317;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution317Test {

    @Test
    public void shortestDistance_1_3_absent() {
        assertEquals(-1, new Solution317().shortestDistance(new int[][]{
                {1,2,0}
        }));
    }

    @Test
    public void shortestDistance_3_5_present() {
        assertEquals(7, new Solution317().shortestDistance(new int[][]{
                {1,0,2,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}
        }));
    }

    @Test
    public void shortestDistance_10_10_test() {
        assertEquals(18, new Solution317().shortestDistance(new int[][]{
                {1,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,1},
        }));
    }

}