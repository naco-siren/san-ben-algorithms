package leetcode.LC_072;


/**
 * 72. Edit Distance
 */
class Solution72 {
    int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();

        // Initialize a 2-D DP matrix
        int[][] dp = new int[1 + len1][1 + len2];
        for(int i = 0; i <= len1; i++)
            dp[i][0] = i;
        for(int j = 0; j <= len2; j++)
            dp[0][j] = j;

        /* DP iteration */
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                dp[i + 1][j + 1] = Math.min(
                        word1.charAt(i) == word2.charAt(j) ? dp[i][j] : dp[i][j] + 1,   // Modify or append current char pair
                        Math.min(dp[i][j + 1], dp[i + 1][j]) + 1                        // Remove either char
                );
            }
        }

        return dp[len1][len2];
    }

    int minDistanceFollowUp(String word1, String word2) {
        final int len1 = word1.length(), len2 = word2.length();

        // Initialize a 1-D DP row
        int[] curr = new int[len2 + 1];
        for (int j = 0; j <= len2; j++)
            curr[j] = j;

        // Perform DP
        for (int i = 0; i < len1; i++) {
            int[] next = new int[len2 + 1];
            next[0] = i + 1;

            for (int j = 0; j < len2; j++) {
                next[j + 1] = Math.min(
                        word1.charAt(i) == word2.charAt(j) ? curr[j] : curr[j] + 1,
                        Math.min(next[j], curr[j + 1]) + 1
                );
            }

            curr = next;
        }
        return curr[len2];
    }

//    int minDistance2(String word1, String word2) {
//        final int len1 = word1.length(), len2 = word2.length();
//
//        /* Initialize the DP matrix */
//        int[][] dp = new int[len1+1][len2+1];
//        for(int i = 0; i <= len2; i++)
//            dp[i][0] = i;
//        for(int j = 0; j <= len1; j++)
//            dp[0][j] = j;
//
//        /* DP */
//        for(int i = 1; i <= len1; i++){
//            for(int j = 1; j <= len2; j++){
//                if (word1.charAt(i-1) == word2.charAt(j-1)) {
//                    dp[i][j] = dp[i-1][j-1];
//                } else {
//                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]));
//                }
//            }
//        }
//        return dp[len1][len2];
//    }
}
