package leetcode.LC_213;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution213Test {

    @Test
    public void searchRange_0() {
        assertArrayEquals(new int[]{-1, -1}, new Solution213().searchRange(new int[]{}, 0));
    }

    @Test
    public void searchRange_1() {
        assertArrayEquals(new int[]{0, 0}, new Solution213().searchRange(new int[]{0}, 0));
        assertArrayEquals(new int[]{-1, -1}, new Solution213().searchRange(new int[]{1}, 0));
    }

    @Test
    public void searchRange_2() {
        assertArrayEquals(new int[]{0, 0}, new Solution213().searchRange(new int[]{1, 2}, 1));
        assertArrayEquals(new int[]{1, 1}, new Solution213().searchRange(new int[]{1, 2}, 2));
        assertArrayEquals(new int[]{0, 1}, new Solution213().searchRange(new int[]{1, 1}, 1));

        assertArrayEquals(new int[]{-1, -1}, new Solution213().searchRange(new int[]{1, 1}, 0));
        assertArrayEquals(new int[]{-1, -1}, new Solution213().searchRange(new int[]{1, 2}, 0));
    }

    @Test
    public void searchRange_4() {
        assertArrayEquals(new int[]{3, 4}, new Solution213().searchRange(new int[]{5,7,7,8,8,10}, 8));
        assertArrayEquals(new int[]{1, 2}, new Solution213().searchRange(new int[]{5,7,7,8,8,10}, 7));

        assertArrayEquals(new int[]{0, 0}, new Solution213().searchRange(new int[]{5,7,7,8,8,10}, 5));
        assertArrayEquals(new int[]{5, 5}, new Solution213().searchRange(new int[]{5,7,7,8,8,10}, 10));

        assertArrayEquals(new int[]{-1, -1}, new Solution213().searchRange(new int[]{5,7,7,8,8,10}, 6));
    }

}