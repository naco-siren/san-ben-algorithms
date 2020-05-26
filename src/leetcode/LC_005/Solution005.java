package leetcode.LC_005;

/**
 * 5. Longest Palindromic Substring
 */
public class Solution005 {

    /*
     * idx: 0   1   2   3   4
     * s:  [b   a   b   a   d]
     * c:   1 2 3 4 5 6 7 8 9
     *      *     ^
     *
     *      *: l = (1 - 1) / 2 = 0, r = 1 / 2 = 0.      `l` and `r` falls onto same index.
     *      ^: l = (4 - 1) / 2 = 1, r = 4 / 2 = 2.      `l` and `r` falls onto different indices.
     *
     */
    String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int len = s.length();

        int maxLen = 1, start = 0;

        int l, r;
        for (int c = 1; c <= 2 * len - 1; c++) {
            for (l = (c - 1) / 2, r = c / 2; l >= 0 && r < len && s.charAt(l) == s.charAt(r); l--, r++);
            l++; r--;   // DON'T FORGET TO ADJUST ON EXITING THE LOOP, WHEN s[l] != s[r]

            int curLen = r - l + 1;
            if (curLen > maxLen) {
                maxLen = curLen;
                start = l;
            }
        }
        return s.substring(start, start + maxLen);
    }
}
