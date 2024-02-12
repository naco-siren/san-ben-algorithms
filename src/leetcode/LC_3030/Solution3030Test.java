package leetcode.LC_3030;

import org.junit.Test;

import static base.TestHelpers.matrixEquals;
import static org.junit.Assert.assertTrue;

public class Solution3030Test {

    @Test
    public void example_0() {
        int[][] input = new int[][] {
                new int[]{5, 6, 7, 10},
                new int[]{8, 9, 10, 10},
                new int[]{11, 12, 13, 10},
        };

        int[][] output = new Solution3030().resultGrid(input, 3);


        int[][] expected = new int[][] {
                new int[]{9, 9, 9, 9},
                new int[]{9, 9, 9, 9},
                new int[]{9, 9, 9, 9},
        };
        assertTrue(matrixEquals(expected, output));
    }

    @Test
    public void test_1() {
        int[][] input = new int[][] {
                new int[]{0, 23, 11},
                new int[]{15, 0, 21},
                new int[]{15, 11, 19},
                new int[]{26, 18, 7},
        };

        int[][] output = new Solution3030().resultGrid(input, 20);

        int[][] expected = new int[][] {
                new int[]{ 0, 23, 11},
                new int[]{15,  0, 21},
                new int[]{15, 11, 19},
                new int[]{26, 18,  7},
        };
        assertTrue(matrixEquals(expected, output));
    }
}
