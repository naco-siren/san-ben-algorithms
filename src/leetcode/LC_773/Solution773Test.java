package leetcode.LC_773;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution773Test {

    @Test
    public void slidingPuzzle_1() {
        assertEquals(1, new Solution773().slidingPuzzle(new int[][]{{1,2,3},{4,0,5}}));
    }

    @Test
    public void slidingPuzzle_2() {
        assertEquals(-1, new Solution773().slidingPuzzle(new int[][]{{1,2,3},{5,4,0}}));
    }

    @Test
    public void slidingPuzzle_3() {
        assertEquals(5, new Solution773().slidingPuzzle(new int[][]{{4,1,2},{5,0,3}}));
    }
}