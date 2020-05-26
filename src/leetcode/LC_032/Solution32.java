package leetcode.LC_032;

import java.util.Stack;

/**
 * 32. Longest Valid Parentheses
 */
class Solution32 {
    /*
     *
     * 0 1 2 3 4 5 6
     *       3
     *     2 2 2
     *   1 1 1 1 1
     * ) ( ( ( ) ) )
     * S              maxLen: 0
     *     2   4      maxLen: 4 - 2 = 2
     *   1       5    maxLen: max(2, 5 - 1) = 4
     * S           6  maxLen: max(4, 6 - S) = 6
     *
     */
    int longestValidParentheses(String s) {
        int maxLen = 0;
        int curStart = -1;  // We need this `curStart` because open left parentheses keep being consumed in a very long sequence,
                            // such as: "(()()()()()()()())", where `curStart` is first `-1` and then always `0`.

        // A stack to memorize indices of previous, i.e. OPEN, left parentheses
        Stack<Integer> lefts = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lefts.push(i);

            } else {
                if (lefts.isEmpty()) {
                    curStart = i;   // This resets the start index for current sequence.

                } else {
                    lefts.pop();    // Consumes the last open left parenthesis, and decide the length of current valid sequence:
                                    // If stack empty: `curStart`, else: the last open left parenthesis.
                    final int prevStart = lefts.isEmpty() ? curStart : lefts.peek();
                    maxLen = Math.max(maxLen, i - prevStart);       // Note that both `curStart` and `lefts.peek()` is the index JUST BEFORE current valid sequence.
                }
            }
        }
        return maxLen;
    }
}
