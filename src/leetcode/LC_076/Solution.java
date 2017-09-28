package leetcode.LC_076;

/**
 * Created by naco_siren on 7/15/17.
 */
public class Solution {
    public static void main(String... args) {

        String r1 = minWindow("a", "a");
        String r2 = minWindow("ADOBECODEBANC", "ABC");

        return;
    }

    public static String minWindow(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return "";
        int m = s.length(), n = p.length();

        /* Initialize a histogram for each character's demand */
        int[] hist = new int[256];
        for (int i = 0; i < n; i++)
            hist[p.charAt(i)]++;
        int count = n; // The total characters' demand we need to meet

        /* Sliding window */
        int minStart = -1, minLen = Integer.MAX_VALUE;
        for (int start = 0, end = 0; end < m; end++) {
            /* Reduce the new character's demand by one */
            if (--hist[s.charAt(end)] >= 0) // If this demand drops below zero, it means that we over supply
                count--;

            /* Continue expanding the window if total demand not met */
            if (count > 0) continue;

            /* If total demand is met, shrink the window */
            while (count == 0) {
                if (++hist[s.charAt(start)] > 0)
                    count++;
                start++;
            }

            /* By now, the count should be 1 */

            /* Update minimum length record */
            if (end - start + 2 < minLen) {
                minLen = end - start + 2; // Because we over shrink the start by 1
                minStart = start - 1; // Because we over shrink the start by 1
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
