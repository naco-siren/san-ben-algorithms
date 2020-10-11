package leetcode.LC_151;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 151. Reverse Words in a String
 */
public class Solution151 {
    /*
     * Approach #1: My Deque
     */
    public String reverseWords(String s) {
        Deque<String> words = parseWords(s + " ");

        StringBuilder builder = new StringBuilder();
        Iterator<String> iter = words.descendingIterator();
        while (iter.hasNext()) {
            builder.append(iter.next());
            if (iter.hasNext())
                builder.append(' ');
        }

        return builder.toString();
    }

    private Deque<String> parseWords(String s) {
        Deque<String> words = new LinkedList<>();

        boolean inWord = false;
        int wordStart = 0;
        for (int i = 0; i < s.length(); i++) {
            final char ch = s.charAt(i);

            if (inWord) {
                if (ch == ' ') {
                    inWord = false;
                    words.add(s.substring(wordStart, i));
                }
            } else {
                if (ch != ' ') {
                    inWord = true;
                    wordStart = i;
                }
            }
        }
        return words;
    }

    /*
     *  Leetcode's Deque
     */
    public String reverseWords1(String s) {
        int left = 0, right = s.length() - 1;
        // remove leading spaces
        while (left <= right && s.charAt(left) == ' ')
            ++left;

        // remove trailing spaces
        while (left <= right && s.charAt(right) == ' ')
            --right;

        Deque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();
        // push word by word in front of deque
        while (left <= right) {
            char c = s.charAt(left);

            if ((word.length() != 0) && (c == ' ')) {
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }

    /*
     * Approach 2: First reverse the whole string, then reverse each words in-place
     */
    public String reverseWords2(String s) {
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

    private void reverse(char[] chars, int start, int end) {
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
