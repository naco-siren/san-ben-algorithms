package leetcode.LC_003;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 3. Longest Substring Without Repeating Characters
 */
public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;

        int maxLen = 0;

        HashMap<Character, Integer> lastPos = new HashMap<>();

        for (int l = 0, r = 0; r < s.length(); r++) {
            final char ch = s.charAt(r);

            // Shrink window's left, then update indices
            final Integer last = lastPos.get(ch);
            if (last != null && last >= l) {
                l = last + 1;
            }
            lastPos.put(ch, r);

            // Update record
            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstring2(String s) {
        final int LEN = s.length();
        int maxLen = 0, maxLeft = 0;

        int[] lastIdx = new int[256];
        Arrays.fill(lastIdx, -1);

        int l = 0;
        for (int r = 0; r < LEN; r++) {
            final char ch = s.charAt(r);

            // Shrink window's left, then update indices
            final int last = lastIdx[ch];
            if (last >= l) {
                l = last + 1;
            }
            lastIdx[ch] = r;

            // Update record
            if (r - l + 1 > maxLen) {
                maxLen = r - l + 1;
                maxLeft = l;
            }
        }
        return maxLen;
    }
}
