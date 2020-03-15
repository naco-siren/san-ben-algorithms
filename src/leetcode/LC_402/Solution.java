package leetcode.LC_402;

import java.util.Stack;

/**
 * 402. Remove K Digits
 */
public class Solution {

    public static String removeKdigits(String num, int k) {
        // Corner cases
        if (num == null) throw new IllegalArgumentException("WTF input num");
        if (k < 0) throw new IllegalArgumentException("WTF input k");
        final int N = num.length();
        if (k >= N) return "0";
        if (k == 0) return num;

        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < N; i++) {
            char ch = num.charAt(i);

            while (k > 0 &&
                    !stk.isEmpty() && ch < stk.peek()) {
                stk.pop();
                k--;
            }

            stk.push(ch);
        }

        // Remove the remaining ones
        while (k > 0) {
            stk.pop();
            k--;
        }

        // Reverse the stack
        Stack<Character> revStk = new Stack<>();
        while (!stk.isEmpty())
            revStk.push(stk.pop());

        // Removing leading zeros but leave the last one
        while (!revStk.isEmpty()) {
            if (revStk.peek() != '0')
                break;

            if (revStk.peek() == '0') {
                if (revStk.size() > 1) {
                    revStk.pop();
                } else {
                    break;
                }
            }
        }

        // Output to String
        StringBuilder builder = new StringBuilder();
        while (!revStk.isEmpty())
            builder.append(revStk.pop());
        return builder.toString();
    }

    public static String removeKdigits_2(String num, int k) {
        // Corner cases
        if (num == null) throw new IllegalArgumentException("WTF input num");
        if (k < 0) throw new IllegalArgumentException("WTF input k");
        int N = num.length();
        if (k >= N) return "0";
        if (k == 0) return num;

        // Get N - k subsequence with smallest digits, i.e. shrink k times
        for (int i = 0; i < k; i++) {
            // Find the first non-ascending digit from left;
            for (int j = 0; j < N; j++) {
                if (j == N - 1 || num.charAt(j) > num.charAt(j+1)) {
                    num = num.substring(0, j).concat(num.substring(j + 1, N));
                    N--;
                    break;
                }
            }
        }

        // Remove leading zeros
        for (int i = 0; i < N; i++) {
            if (i == N - 1 || num.charAt(i) != '0') {
                num = num.substring(i, N);
                break;
            }
        }
        return num;
    }
}
