package leetcode.LC_022;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private static final char LEFT_PARENTHESIS = '(';
    private static final char RIGHT_PARENTHESIS = ')';

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<String> r1 = solution.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        List<String> results = new LinkedList<>();
        recur(n * 2, 0, 0, new StringBuilder(), results);
        return results;
    }

    private void recur(int n, int i, int l, StringBuilder prefix, List<String> results) {
        if (i == n) {
            if (l == 0)
                results.add(prefix.toString());

        } else {
            // Append a left parenthesis
            prefix.append(LEFT_PARENTHESIS);
            recur(n, i + 1, l + 1, prefix, results);
            prefix.setLength(i);    // Backtracking

            // Append a right parenthesis if left brackets more than right ones in prefix
            if (l > 0) {
                prefix.append(RIGHT_PARENTHESIS);
                recur(n, i + 1, l - 1, prefix, results);
                prefix.setLength(i);    // Backtracking
            }
        }
    }
}
