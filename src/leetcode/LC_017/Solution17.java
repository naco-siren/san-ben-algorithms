package leetcode.LC_017;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 */
class Solution17 {
    private static final char[][] CHARS = new char[][]{
            {}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        helper(digits, 0, new StringBuilder(), results);
        return results;
    }

    private void helper(String digits, int index, StringBuilder prefix, List<String> results) {
        if (index == digits.length()) {
            if (prefix.length() > 0)
                results.add(prefix.toString());
            return;
        }

        for (char ch : CHARS[digits.charAt(index) - '1']) {
            prefix.append(ch);
            helper(digits, index + 1, prefix, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
