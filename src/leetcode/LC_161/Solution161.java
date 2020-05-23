package leetcode.LC_161;

/**
 * 161. One Edit Distance
 */
class Solution161 {
    boolean isOneEditDistance(String s, String t) {
        // Early return on edge cases
        final int M = s.length(), N = t.length();
        if (M > N + 1 || N > M + 1)
            return false;

        // Make sure `s` is shorter than `t`
        if (M > N)
            return isOneEditDistance(t, s);

        for (int i = 0; i < M; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (M == N) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }

        // If there is no diffs on `M` distance, the strings are one edit away
        // only if `t` has exactly one more character.
        return M + 1 == N;
    }
}
