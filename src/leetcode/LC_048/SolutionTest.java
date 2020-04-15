package leetcode.LC_048;

import org.junit.Test;

import static leetcode.LC_048.Solution.rotate;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void rotate_3() {
        int[][] input = new int[][]{
                new int[]{1, 2 ,3},
                new int[]{4, 5 ,6},
                new int[]{7, 8, 9}
        };

        rotate(input);

        int[][] expected = new int[][]{
                new int[]{7, 4, 1},
                new int[]{8, 5, 2},
                new int[]{9, 6, 3}
        };

        for (int i = 0; i < input.length; i++)
            assertArrayEquals(expected[i], input[i]);
    }

    @Test
    public void rotate_4() {
        int[][] input = new int[][]{
                new int[]{1,2,3,4},
                new int[]{5,6,7,8},
                new int[]{9,10,11,12},
                new int[]{13,14,15,16}
        };

        rotate(input);

        int[][] expected = new int[][]{
                new int[]{13,9,5,1},
                new int[]{14,10,6,2},
                new int[]{15,11,7,3},
                new int[]{16,12,8,4}
        };

        for (int i = 0; i < input.length; i++)
            assertArrayEquals(expected[i], input[i]);
    }
}