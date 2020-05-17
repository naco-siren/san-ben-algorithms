package leetcode.LC_304;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution304Test {

    @Test
    public void sumRegion_empty() {
        Solution304.NumMatrix numMatrix = new Solution304.NumMatrix(new int[][]{{}});
    }

    @Test
    public void sumRegion_5_by_5() {
        Solution304.NumMatrix numMatrix = new Solution304.NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5},
        });

        assertEquals(8, numMatrix.sumRegion(2, 1, 4, 3));
        assertEquals(11, numMatrix.sumRegion(1, 1, 2, 2));
        assertEquals(12, numMatrix.sumRegion(1, 2, 2, 4));
    }
}