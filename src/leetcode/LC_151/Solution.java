package leetcode.LC_151;

/**
 * Created by naco_siren on 9/26/17.
 */
public class Solution {

    public static void main(String[] args) {
        String r1 = reverseWords("Allah Akbar BOOM SHAKALAKA");

        return;
    }

    public static String reverseWords(String s) {
        if (s == null) return s;
        char[] chars = s.toCharArray();
        int n = chars.length;

        /* Reverse the whole string */
        reverse(chars, 0, n-1);

        /* Reverse the words one by one */
        int i = 0, j = 0;
        while (i < n) {
            /* Find the start of a word */
            while (i < n && chars[i] == ' ') i++;

            /* Find the end of this word */
            j = i + 1;
            while (j < n && chars[j] != ' ') j++;
            j--;

            /* Reverse current word */
            reverse(chars, i, j);

            /* Continue to find next word */
            i = j + 1;
        }

        return new String(chars);
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            /* Swap */
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;

            /* Narrow */
            start++; end--;
        }
    }
}
