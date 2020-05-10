package leetcode.LC_034;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution34Test {

    @Test
    public void searchRange_6_5_5__5() {
        assertArrayEquals(
                new int[]{-1, -1},
                new Solution34().searchRange(new int[]{6,5,5}, 5));
    }

    @Test
    public void searchRange_5_5_5__5() {
        assertArrayEquals(
                new int[]{0, 2},
                new Solution34().searchRange(new int[]{5,5,5}, 5));
    }

    @Test
    public void searchRange_5_6_6_7__4() {
        assertArrayEquals(
                new int[]{-1, -1},
                new Solution34().searchRange(new int[]{5,6,6,7}, 4));
    }

    @Test
    public void searchRange_5_7_7_8_8_10__8() {
        assertArrayEquals(
                new int[]{3, 4},
                new Solution34().searchRange(new int[]{5,7,7,8,8,10}, 8));
    }

    @Test
    public void searchRange_5_7_7_8_8_10__6() {
        assertArrayEquals(
                new int[]{-1, -1},
                new Solution34().searchRange(new int[]{5,7,7,8,8,10}, 6));
    }
}