package leetcode.LC_005;

/**
 * Created by naco_siren on 8/22/17.
 */
public class Solution {

    public static void main(String[] args) {
        Solution lc = new Solution();

        String r1 = longestPalindrome("cbabab");
        return;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int len = s.length();

        int maxLen = 1, start = 0;

        int l, r;
        for (int c = 1; c <= 2 * len - 1; c++) {
            for (l = (c - 1) / 2, r = c / 2; l >= 0 && r < len && s.charAt(l) == s.charAt(r); l--, r++);
            int curLen = r - l - 1;
            if (curLen > maxLen) {
                maxLen = curLen;
                start = l + 1;
            }
        }
        return s.substring(start, start + maxLen);
    }
}
