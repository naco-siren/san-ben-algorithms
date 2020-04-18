package leetcode.LC_064;

/**
 * 64. Minimum Path Sum
 */
class Solution {
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
            return 0;

        // Initialize a 2-D DP matrix
        final int M = grid.length, N = grid[0].length;
        int[][] dp = new int[M][];
        for (int i = 0; i < M; i++)
            dp[i] = new int[N];

        // Prefill DP matrix's top-left, first row and first column
        dp[0][0] = grid[0][0];
        for (int c = 1; c < N; c++)
            dp[0][c] = dp[0][c-1] + grid[0][c];
        for (int r = 1; r < M; r++)
            dp[r][0] = dp[r-1][0] + grid[r][0];

        // Perform dynamic programming
        for (int r = 1; r < M; r++)
            for (int c = 1; c < N; c++)
                dp[r][c] = grid[r][c] + Math.min(dp[r-1][c], dp[r][c-1]);
        return dp[M-1][N-1];
    }
}
