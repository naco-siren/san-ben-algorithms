package leetcode.LC_1143;

/**
 * 1143. Longest Common Subsequence
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) return -1;

        // Initialize a 2-D matrix to memorize the length of longest subsequence by far
        final int len1 = text1.length(), len2 = text2.length();
        final int[][] DP = new int[len1 + 1][];
        for (int i = 0; i < len1 + 1; i++)
            DP[i] = new int[len2 + 1];

        // Peform dynamic programming
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    DP[i][j] = Math.max(DP[i-1][j-1] + 1, Math.max(DP[i-1][j], DP[i][j-1]));
                } else {
                    DP[i][j] = Math.max(DP[i-1][j-1], Math.max(DP[i-1][j], DP[i][j-1]));
                }
            }
        }
        return DP[len1][len2];
    }
}
