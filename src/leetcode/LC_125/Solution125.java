package leetcode.LC_125;

/**
 * 125. Valid Palindrome
 */
class Solution125 {
    boolean isPalindrome(String s) {
        final char[] chars = s.toLowerCase().toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(chars[i]))
                i++;
            while (j > i && !Character.isLetterOrDigit(chars[j]))
                j--;

            if (chars[i] != chars[j])
                return false;

            i++;
            j--;
        }
        return true;
    }
}
