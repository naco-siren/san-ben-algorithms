package leetcode.LC_415;

/**
 * 415. Add Strings
 */
class Solution415 {
    String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();

        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        while (carry > 0 || i >= 0 || j >= 0) {
            final int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            final int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            final int sum = digit1 + digit2 + carry;

            final char ch = (char) ('0' + (sum >= 10 ? sum - 10 : sum));
            builder.append(ch);

            carry = sum >= 10 ? 1 : 0;
            if (i >= 0)
                i--;
            if (j >= 0)
                j--;
        }
        return builder.reverse().toString();
    }
}
