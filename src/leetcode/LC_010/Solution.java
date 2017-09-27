package leetcode.LC_010;

/**
 * Created by naco_siren on 9/26/17.
 */
public class Solution{
    public static void main(String[] args) {
        boolean r1 = isMatch("aa", "a*");
        return;
    }

    public static boolean isMatch(String s, String p) {
        int sL = s.length(), pL = p.length();

        boolean[][] dp = new boolean[sL + 1][pL + 1];
        dp[0][0] = true; // "" and "" matches

        for (int i = 0; i <= sL; i++) {

            // j starts from 1, since dp[i][0] is false when i!=0;
            for(int j = 1; j <= pL; j++) {
                char ch = p.charAt(j-1);

                if (ch != '*') {
                    // The last character of s and p should match,
                    // and s[:i-1] should match p[:j-1]
                    dp[i][j] = i > 0 && dp[i-1][j-1] && (ch == '.' || ch == s.charAt(i-1));

                } else {
                    // Two situations:
                    // (1) s[:i] matches p[:j-2], and there is 0 preceding element of '*';
                    // (2) The last character of s should match the preceding element of '*';
                    //     And, dp[i-1][j] should be true;
                    dp[i][j] = (j > 1 && dp[i][j-2]) ||
                            (i > 0 && dp[i-1][j] && (p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.'));
                }
            }
        }

        return dp[sL][pL];
    }
}