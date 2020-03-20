package leetcode.LC_946;

import java.util.Stack;

/**
 * 946. Validate Stack Sequences
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        final int N = pushed.length;

        Stack<Integer> stack = new Stack<>();
        int i = 0, j = 0;
        while (j < N) {
            if (i < N && (stack.isEmpty() || stack.peek() != popped[j])) {
                stack.push(pushed[i]);
                i++;
                continue;
            }

            if (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            } else {
                return false;
            }
        }
        return true;
    }
}