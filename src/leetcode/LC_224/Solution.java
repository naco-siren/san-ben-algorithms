package leetcode.LC_224;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        int r1 = calculate("1 + 1");                // 2
        int r2 = calculate(" 2-1 + 2 ");            // 3
        int r3 = calculate("(1+(4+5+2)-3)+(6+8)");  // 23
    }

    public static int calculate(String s) {
        int sum = 0;

        Stack<Boolean> signs = new Stack<>(); signs.push(true);

        boolean isPos = true;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                // Add current number
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    num = num * 10 + (s.charAt(i++) - '0');
                sum = sum + (signs.peek() == isPos ? num : -num);

                i--;    // Hedge the loop's self-inc

            } else if (Character.isSpaceChar(s.charAt(i))) {
                // Skip blank spaces
                continue;

            } else {
                // Switch signs
                switch (s.charAt(i)) {
                    case '(':
                        signs.push(isPos == signs.peek());
                        isPos = true;
                        break;
                    case ')':
                        signs.pop();
                        break;
                    default:
                        isPos = s.charAt(i) == '+';
                        break;
                }

            }
        }
        return sum;
    }
}
