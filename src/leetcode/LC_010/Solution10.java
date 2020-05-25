package leetcode.LC_010;

/**
 * 10. Regular Expression Matching
 */
public class Solution10 {

    boolean isMatch(String s, String p) {
        final int sLen = s.length(), pLen = p.length();

        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true; // "" and "" matches

        for (int i = 0; i <= sLen; i++) {
            // NOTE that we cannot obtain `s.charAt(i - 1)` here because `i` starts from `0` (i.e. matrix-based index)

            // `j` starts from `1`, since dp[i][0] is false for `i > 0`.
            for(int j = 1; j <= pLen; j++) {
                final char pp = p.charAt(j-1);

                if (pp == '*') {
                    // Two situations:
                    dp[i][j] =
                            // (1) s[:i] matches p[:j-2], and there is zero preceding elements of '*', i.e. p[j-1] is omitted by '*';
                            (j > 1 && dp[i][j-2])

                                ||

                            // (2) s[:i-1] matches p[:j], and s[i] matches the preceding element of '*'.
                            //      i.e. if (`ab*` matches `ab`) and (`b` == `b`), then (`ab*` matches `abb`).
                            //                                (Note that `p.charAt(j-2)` below is the character right before `*`)
                            (i > 0 && dp[i-1][j]
                                    && (p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.'));
                } else {
                    // The last character of s and p should match,
                    // and s[:i-1] should match p[:j-1]
                    dp[i][j] = i > 0 && dp[i-1][j-1] && (pp == '.' || pp == s.charAt(i-1));
                }
            }
        }

        return dp[sLen][pLen];
    }
}