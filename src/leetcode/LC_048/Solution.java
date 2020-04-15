package leetcode.LC_048;

/**
 * 48. Rotate Image
 */
public class Solution {
    public static void rotate(int[][] matrix) {
        final int N = matrix.length;
        for (int r = 0; r < N / 2; r++) {
            for (int c = r; c < N - 1 - r; c++) {
                final int temp = matrix[r][c];
                matrix[r][c] = matrix[N - 1 - c][r];
                matrix[N - 1 - c][r] = matrix[N - 1 - r][N - 1 - c];
                matrix[N - 1 - r][N - 1 - c] = matrix[c][N - 1 - r];
                matrix[c][N - 1 - r] = temp;
            }
        }
    }
}
