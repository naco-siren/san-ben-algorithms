package leetcode.LC_680;

/**
 * 680. Valid Palindrome II
 */
public class Solution680 {
    boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return helper(s, i + 1, j) || helper(s, i, j - 1);
        }
        return true;
    }

    private boolean helper(String s, int l, int r) {
        for (int i = l, j = r; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }
}
