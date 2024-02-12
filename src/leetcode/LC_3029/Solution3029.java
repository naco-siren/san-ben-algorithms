package leetcode.LC_3029;

/**
 * 3029. Minimum Time to Revert Word to Initial State I
 */
public class Solution3029 {
    public int minimumTimeToInitialState(String word, int k) {
        final char[] chars = word.toCharArray();

        int seconds = 1;
        int start = k;

        while (start < word.length()) {
            if (match(chars, start))
                break;

            seconds++;
            start += k;
        }

        return seconds;
    }

    private boolean match(char[] chars, int start) {
        final int N = chars.length;
        for (int i = 0; start + i < N; i++)
            if (chars[i] != chars[start + i])
                return false;
        return true;
    }
}
