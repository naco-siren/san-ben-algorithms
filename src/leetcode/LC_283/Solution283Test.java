package leetcode.LC_283;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution283Test {

    @Test
    public void moveZero_1() {
        final int[] input = new int[]{0,1,0,3,12};
        final int[] output = new int[]{1,3,12,0,0};
        new Solution283().moveZero(input);
        assertArrayEquals(output, input);
    }

    @Test
    public void moveZero_2() {
        final int[] input = new int[]{0, 1, 4, 0, 2, 0, 8, 0, 0, 5, 0, 7};
        final int[] output = new int[]{1, 4, 2, 8, 5, 7, 0, 0, 0, 0, 0, 0};
        new Solution283().moveZero(input);
        assertArrayEquals(output, input);
    }
}