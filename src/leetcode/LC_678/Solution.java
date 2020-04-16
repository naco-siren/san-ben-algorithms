package leetcode.LC_678;

/**
 * 678. Valid Parenthesis String
 */
public class Solution {
    public boolean checkValidString(String s) {
        // Safeguard & early return
        int n = s.length();
        if (n == 0) return true;
        final boolean[][] dp = new boolean[n][n];

        // For subarrays of size 1
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') dp[i][i] = true;
            if (i < n-1
                    && (s.charAt(i) == '(' || s.charAt(i) == '*')
                    && (s.charAt(i+1) == ')' || s.charAt(i+1) == '*')) {
                dp[i][i+1] = true;
            }
        }

        // For subarrays of size over 1
        for (int size = 2; size < n; size++) {
            for (int i = 0; i + size < n; i++) {
                if (s.charAt(i) == '*' && dp[i+1][i+size]) {
                    // Current `*` translates into empty char.
                    dp[i][i+size] = true;
                } else if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                    // Current `*` translates into `(`.
                    for (int k = i+1; k <= i+size; k++) {
                        if ((s.charAt(k) == ')' || s.charAt(k) == '*') &&
                                (k == i+1 || dp[i+1][k-1]) &&
                                (k == i+size || dp[k+1][i+size])) {
                            // We've found a `)` or equivalent `*` at index `k`.
                            dp[i][i+size] = true;
                        }
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
