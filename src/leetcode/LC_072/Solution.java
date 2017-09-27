package leetcode.LC_072;

import java.util.ArrayList;

/**
 * Created by naco_siren on 9/17/17.
 */
public class Solution {
    public static void main(String[] args) {

        int d1 = minEditDist2("abc", "bcd");


        return;
    }

    public static int minEditDist(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();

        /* Initialize the DP matrix */
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 0; i <= len2; i++)
            dp[i][0] = i;
        for(int j = 0; j <= len1; j++)
            dp[0][j] = j;

        /* DP */
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[len1][len2];
    }

    public static int minEditDist2(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();

        /* Initialize the DP matrix */
        int[][] dp = new int[1 + len1][1 + len2];
        for(int i = 0; i <= len1; i++)
            dp[i][0] = i ;
        for(int j = 0; j <= len2; j++)
            dp[0][j] = j;

        /* DP iteration */
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                dp[i][j] = Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1);

                int margin = word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1;
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + margin);
            }
        }

        return dp[len1][len2];
    }


}
