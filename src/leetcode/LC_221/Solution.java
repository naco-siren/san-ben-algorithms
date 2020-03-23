package leetcode.LC_221;

/**
 * 221. Maximal Square
 */
public class Solution {
    public static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int r = matrix.length, c = matrix[0].length;

        // Initialize max edge length cache and DP matrix.
        int max = 0;
        int[][] dp = new int[r + 1][c + 1];     // [0][x] & [x][0] are two sentinel edges to avoid index out of boundary

        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                // `i` & `j` here is 1-based index, corresponding to `ith row` & `jth col`
                if (matrix[i-1][j-1] == '1') {

                    /**
                     *
                     * 0  0
                     * 0 (1)     = 1
                     *
                     * 0  1
                     * 1 (1)     = 1
                     *
                     * 1  1
                     * 1 (1)     = 2
                     *
                     */
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;

                    if (dp[i][j] > max)
                        max = dp[i][j];
                }
            }
        }

        return max * max;
    }
}
