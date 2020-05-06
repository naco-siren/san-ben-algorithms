package leetcode.LC_953;

import java.util.Arrays;

/**
 * 953. Verifying an Alien Dictionary
 */
class Solution953 {
    static boolean isAlienSorted(String[] words, String order) {
        // Handle corner case
        if (words.length < 2)
            return true;

        // Construct an index of alien chars
        int[] index = constructIndex(order);

        // Compare each word with its precedent
        for (int i = 1; i < words.length; i++)
            if (!inOrder(index, words[i-1], words[i]))
                return false;
        return true;
    }

    static int[] constructIndex(final String order) {
        final int[] index = new int[256];
        Arrays.fill(index, -1);
        for (int i = 0; i < order.length(); i++) {
            if (index[order.charAt(i)] != -1)
                throw new IllegalArgumentException("Incorrect `order` input!");
            index[order.charAt(i)] = i;
        }
        return index;
    }

    static boolean inOrder(final int[] index, final String word1, final String word2) {
        int i = 0, minLen = Math.min(word1.length(), word2.length());
        while (i < minLen) {
            final char ch1 = word1.charAt(i), ch2 = word2.charAt(i);
            if (ch1 == ch2) {
                i++;
                continue;
            } else {
                return index[ch1] < index[ch2];
            }
        }

        return i == word1.length();
    }
}
