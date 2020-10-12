package leetcode.LC_670;

/**
 * 670. Maximum Swap
 */
public class Solution670 {
    public int maximumSwap(int num) {
        final char[] chars = String.valueOf(num).toCharArray();
        if (chars.length < 2)
            return num;

        // Map each digit to the index of its last occurence
        int[] lastMap = new int[10];
        for (int i = 0; i < chars.length; i++)
            lastMap[chars[i] - '0'] = i;

        // Scan from left to right,
        // for each digit: make a swap if a larger digit occurs after it
        for (int i = 0; i < chars.length; i++) {
            final char ch = chars[i];
            for (int digit = 9; digit > ch - '0'; digit--) {
                final int lastIdx = lastMap[digit];
                if (lastIdx > i) {
                    chars[i] = chars[lastIdx];
                    chars[lastIdx] = ch;
                    return Integer.parseInt(new String(chars));
                }
            }
        }

        return num;
    }
}
