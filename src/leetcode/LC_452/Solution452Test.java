package leetcode.LC_452;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution452Test {

    @Test
    public void findMinArrowShots_1() {
        assertEquals(2, new Solution452().findMinArrowShots(new int[][]{
                {9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}
        }));
    }

    @Test
    public void findMinArrowShots_2() {
        assertEquals(2, new Solution452().findMinArrowShots(new int[][]{
                {10,16}, {2,8}, {1,6}, {7,12}
        }));
    }
}