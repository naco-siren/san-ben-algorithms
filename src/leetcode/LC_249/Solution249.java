package leetcode.LC_249;

import java.util.*;

/**
 * 249. Group Shifted Strings
 */
public class Solution249 {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> root2children = new HashMap<>();

        // Map each word to its root, then append it in the map
        for (String word : strings) {
            final String root = findRoot(word);
            root2children.computeIfAbsent(root, irre -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(root2children.values());
    }

    String findRoot(String word) {
        if (word == null || word.isEmpty())
            throw new IllegalArgumentException("Word has to be non-empty!");

        final int offset = 'a' - word.charAt(0);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            final char srcChar = word.charAt(i);
            final char destChar = offsetBy('a', srcChar - 'a' + offset);
            builder.append(destChar);
        }
        return builder.toString();
    }

    // Can't believe `-1 % 26 == -1`
    char offsetBy(char ch, int offset) {
        offset = offset % 26;
        if (offset < 0)
            offset += 26;
        return (char) (ch + offset);
    }
}
