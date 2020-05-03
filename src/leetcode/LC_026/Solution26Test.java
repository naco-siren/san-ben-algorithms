package leetcode.LC_026;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution26Test {

    @Test
    public void removeDuplicates_empty() {
        final int[] input = new int[]{};
        assertEquals(0, new Solution26().removeDuplicates(input));
    }

    @Test
    public void removeDuplicates_0() {
        final int[] input = new int[]{0};
        final int[] expected = new int[]{0};
        assertEquals(expected.length, new Solution26().removeDuplicates(input));
        for (int i = 0; i < expected.length; i++)
            assertEquals(expected[i], input[i]);
    }

    @Test
    public void removeDuplicates_1_1() {
        final int[] input = new int[]{1,1};
        final int[] expected = new int[]{1};
        assertEquals(expected.length, new Solution26().removeDuplicates(input));
        for (int i = 0; i < expected.length; i++)
            assertEquals(expected[i], input[i]);
    }

    @Test
    public void removeDuplicates_1_1_2() {
        final int[] input = new int[]{1,1,2};
        final int[] expected = new int[]{1,2};
        assertEquals(expected.length, new Solution26().removeDuplicates(input));
        for (int i = 0; i < expected.length; i++)
            assertEquals(expected[i], input[i]);
    }

    @Test
    public void removeDuplicates_0_0_1_1_1_2_2_3_3_4() {
        final int[] input = new int[]{0,0,1,1,1,2,2,3,3,4};
        final int[] expected = new int[]{0,1,2,3,4};
        assertEquals(expected.length, new Solution26().removeDuplicates(input));
        for (int i = 0; i < expected.length; i++)
            assertEquals(expected[i], input[i]);
    }
}