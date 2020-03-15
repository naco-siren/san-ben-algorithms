package leetcode.LC_059;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void generateMatrix_1() {
        Solution solution = new Solution();
        int[][] result = solution.generateMatrix(1);

        assertEquals(1, result.length);
        assertEquals(1, result[0].length);
        assertEquals(1, result[0][0]);
    }

    @Test
    public void generateMatrix_2() {
        Solution solution = new Solution();
        int[][] result = solution.generateMatrix(2);

        assertEquals(2, result.length);
        assertEquals(2, result[0].length);
        assertEquals(2, result[1].length);
        assertEquals(1, result[0][0]);
        assertEquals(2, result[0][1]);
        assertEquals(4, result[1][0]);
        assertEquals(3, result[1][1]);
    }

    @Test
    public void generateMatrix_3() {
        Solution solution = new Solution();
        int[][] result = solution.generateMatrix(3);

        assertEquals(3, result.length);
        assertEquals(3, result[0].length);
        assertEquals(3, result[1].length);
        assertEquals(3, result[2].length);
        assertEquals(1, result[0][0]);
        assertEquals(2, result[0][1]);
        assertEquals(3, result[0][2]);
        assertEquals(4, result[1][2]);
        assertEquals(5, result[2][2]);
        assertEquals(6, result[2][1]);
        assertEquals(7, result[2][0]);
        assertEquals(8, result[1][0]);
        assertEquals(9, result[1][1]);
    }

    @Test
    public void generateMatrix_4() {
        Solution solution = new Solution();
        int[][] result = solution.generateMatrix(4);

        assertEquals(4, result.length);
        assertEquals(4, result[0].length);
        assertEquals(4, result[1].length);
        assertEquals(4, result[2].length);
        assertEquals(4, result[3].length);
        assertEquals(1, result[0][0]);
        assertEquals(2, result[0][1]);
        assertEquals(3, result[0][2]);
        assertEquals(4, result[0][3]);
        assertEquals(5, result[1][3]);
        assertEquals(6, result[2][3]);
        assertEquals(7, result[3][3]);
        assertEquals(8, result[3][2]);
        assertEquals(9, result[3][1]);
        assertEquals(10, result[3][0]);
        assertEquals(11, result[2][0]);
        assertEquals(12, result[1][0]);
        assertEquals(13, result[1][1]);
        assertEquals(14, result[1][2]);
        assertEquals(15, result[2][2]);
        assertEquals(16, result[2][1]);
    }


}
