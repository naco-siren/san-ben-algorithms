package leetcode.LC_247;

import java.util.*;

/**
 * 247. Strobogrammatic Number II
 */
class Solution247 {
    static char[] SYMMS = new char[]{'0', '1', '8'};
    static char[][] DIGITS = new char[][]{{'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

    List<String> findStrobogrammatic(int n) {
        List<String> results = new ArrayList<>();
        char[] num = new char[n];
        dfs(results, num, 0, n - 1);
        return results;
    }

    void dfs(
            List<String> results, char[] num,       // Use Char array as StringBuilder, IMPRESSIVE!!
            int lo, int hi                      // A bit similar to quick sort's `L` & `R` pointers
    ) {
        // When two pointers across each other, i.e. `n` is even, collect result and quit.
        if (hi < lo) {
            results.add(new String(num));
            return;
        }

        // When two pointers met, i.e. `n` is odd, pop SYMMetrical digits as the middle digit.
        if (hi == lo) {
            for (char c : SYMMS) {
                num[lo] = c;
                results.add(new String(num));
            }
            return;
        }

        // When start index is not at `0`.
        if (lo != 0) {
            num[lo] = '0';
            num[hi] = '0';
            dfs(results, num, lo + 1, hi - 1);
        }

        // DFS recursion
        for (int i = 0; i < DIGITS.length; i++) {
            num[lo] = DIGITS[i][0];
            num[hi] = DIGITS[i][1];
            dfs(results, num, lo + 1, hi - 1);
        }
    }
}
