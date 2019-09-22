package leetcode.LC_059;

/**
 * 59. Spiral Matrix II
 *
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 *
 *  1  2  3  4
 * 12 13 14  5
 * 11 16 15  6
 * 10  9  8  7
 *
 *
 *  1  2  3  4  5
 * 16 17 18 19  6
 * 15 24 25 20  7
 * 14 23 22 21  8
 * 13 12 11 10  9
 *
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) throw new IllegalArgumentException("Invalid input N");

        int[][] result = new int[n][];
        for (int i = 0; i < n; i++) {
            result[i] = new int[n];
        }

        int counter = 1;
        for (int d = 0; d < n / 2; d++) {
            int count = n - 1 - d * 2;

            // Up
            for (int i = 0; i < count; i++)
                result[d][d + i] = counter++;


            // Right
            for (int i = 0; i < count; i++)
                result[d+i][n-1-d] = counter++;

            // Down
            for (int i = 0; i < count; i++)
                result[n-1-d][n-1-d-i] = counter++;

            // Left
            for (int i = 0; i < count; i++)
                result[n-1-d-i][d] = counter++;
        }

        if (n % 2 == 1)
            result[n / 2][n / 2] = n * n;

        return result;
    }
}
