package leetcode.LC_266;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        boolean r1 = solution.canPermutePalindrome("code");
        boolean r2 = solution.canPermutePalindrome("aab");
        boolean r3 = solution.canPermutePalindrome("carerac");
    }

    private static final int ASCII_CHAR_COUNT = 256;

    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return false;

        int[] histogram = new int[ASCII_CHAR_COUNT];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            histogram[ch]++;
        }

        boolean isOdd = false;
        for (int i = 0; i < ASCII_CHAR_COUNT; i++) {
            if (histogram[i] % 2 == 1) {
                if (isOdd) {
                    return false;
                } else {
                    isOdd = true;
                }
            }
        }
        return true;
    }
}
