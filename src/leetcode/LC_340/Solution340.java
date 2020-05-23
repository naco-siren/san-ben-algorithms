package leetcode.LC_340;

import java.util.Arrays;

/**
 * 340. Longest Substring with At Most K Distinct Characters
 */
class Solution340 {
    int lengthOfLongestSubstringKDistinct(String s, int k) {
        final int LEN = s.length();
        int maxLen = 0, maxLeft = 0;

        // Initialize a histogram to memorize each char's count
        int[] histogram = new int[256];
        Arrays.fill(histogram, 0);

        int distincts = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            // Expand on right
            if (histogram[s.charAt(r)]++ == 0)
                distincts++;

            // Shrink on left, until distinct chars drop to exactly `k`
            while (distincts > k) {
                if (histogram[s.charAt(l++)]-- == 1)
                    distincts--;
            }

            int curLen = r - l + 1;
            if (curLen > maxLen) {
                maxLen = curLen;
                maxLeft = l;
            }
        }
        return maxLen;
    }
}
