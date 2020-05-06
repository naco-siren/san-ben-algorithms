package leetcode.LC_973;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution973Test {

    @Test
    public void kClosest_1() {
        int[][] result = new Solution973().kClosest(new int[][]{
                new int[]{1, 3},
                new int[]{-2, 2}
        },1);
        assertEquals(1, result.length);
        assertArrayEquals(new int[]{-2, 2}, result[0]);
    }
    @Test

    public void kClosest_2() {
        int[][] result = new Solution973().kClosest(new int[][]{
                new int[]{3, 3},
                new int[]{5, -1},
                new int[]{-2, 4}
        }, 2);
        assertEquals(2, result.length);
        assertArrayEquals(new int[]{3,3}, result[0]);
        assertArrayEquals(new int[]{-2,4}, result[1]);
    }
}