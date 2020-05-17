package leetcode.LC_311;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution311Test {

    @Test
    public void multiply_1() {
        int[][] result = new Solution311().multiply(
                new int[][]{
                        {1, 0, 0},
                        {-1, 0, 3}},
                new int[][]{
                        {7, 0, 0},
                        {0, 0, 0},
                        {0, 0, 1}});

        int[][] expected = new int[][]{
                {7, 0, 0},
                {-7, 0, 3}
        };
        assertEquals(expected.length, result.length);
        for (int i = 0; i < expected.length; i++)
            assertArrayEquals(expected[i], result[i]);
    }
}