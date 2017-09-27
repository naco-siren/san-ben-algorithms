package leetcode.LC_076;

/**
 * Created by naco_siren on 7/15/17.
 */
public class Solution {
    public static void main(String... args) {

        String r1 = minWindow("a", "a");

        return;
    }

    public static String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0)
            return "";
        s = s.toUpperCase(); t = t.toUpperCase();
        int m = s.length(), n = t.length();

        int[] hist = new int[26];
        for (int i = 0; i < n; i++)
            hist[t.charAt(i) - 'A']++;
        int count = n;

        int minStart = -1, minLen = Integer.MAX_VALUE;
        for (int start = 0, end = 0; end < m; end++) {
            if (--hist[s.charAt(end) - 'A'] >= 0)
                count--;
            if (count > 0)
                continue;

            while (count == 0) {
                if (++hist[s.charAt(start) - 'A'] > 0)
                    count++;
                start++;
            }
            if (end - start + 2 < minLen) {
                minLen = end - start + 2;
                minStart = start - 1;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen -1);
    }
}
