package leetcode.LC_296;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution296Test {

    @Test
    public void minTotalDistance() {
        assertEquals(6, new Solution296().minTotalDistance(new int[][]{
                new int[]{1,0,0,0,1},
                new int[]{0,0,0,0,0},
                new int[]{0,0,1,0,0},
        }));
    }
}