package leetcode.LC_076;

/**
 * 76. Minimum Window Substring
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 *
 */
class Solution76 {
    String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        int m = s.length(), n = t.length();

        // Initialize a histogram for each character's demand
        int[] hist = new int[256];
        for (int i = 0; i < n; i++)
            hist[t.charAt(i)]++;
        int remains = n; // The total characters' demand we need to meet

        // Sliding window
        int minStart = -1, minLen = Integer.MAX_VALUE;
        for (int l = 0, r = 0; r < m; r++) {
            // Reduce the new character's demand by one
            if (--hist[s.charAt(r)] >= 0) // If this demand drops below zero, it means that we over supply
                remains--;

            // Continue expanding the window if total demand not met
            if (remains > 0)
                continue;

            // If total demand is met, shrink the window
            while (remains == 0) {
                if (++hist[s.charAt(l++)] > 0)
                    remains++;
            }

            /* By now, `remains` should be 1 */

            // Update minimum length record
            if (r - l + 2 < minLen) {
                minLen = r - l + 2;     // Because we over shrink the start by 1
                minStart = l - 1;       // Because we over shrink the start by 1
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
