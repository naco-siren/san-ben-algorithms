package leetcode.LC_043;

/**
 * 43. Multiply Strings
 *
 * Created by naco_siren on 8/17/17.
 */
public class Solution {
    public static String multiply(String num1, String num2) {
        // Early return on corner case
        if ("0".equals(num1) || "0".equals(num2))
            return "0";

        // Perform multiplication by the intuitive way
        final int len1 = num1.length(), len2 = num2.length();
        final char[] chars1 = num1.toCharArray(), chars2 = num2.toCharArray();
        final char[] result = new char[len1 + len2];
        for (int i = 0; i < len1; i++) {
            final int op1 = chars1[len1 - 1 - i] - '0';
            for (int j = 0; j < len2; j++) {
                final int op2 = chars2[len2 - 1 - j] - '0';
                final int product = op1 * op2;
                result[i + j] += product;
                if (result[i + j] >= 10) {
                    result[i + j + 1] += result[i + j] / 10;
                    result[i + j] %= 10;
                }
            }
        }

        // Find the first non-zero number from the end of the result array
        int start = len1 + len2 - 1;
        while (start < len1 + len2 && result[start] == 0)
            start--;

        // Format result chars into String
        StringBuilder builder = new StringBuilder();
        for (int i = start; i >= 0; i--) {
            builder.append((char) ('0' + result[i]));
        }
        return builder.toString();
    }

    public static String multiply2(String num1, String num2) {
        // Early return on corner case
        if ("0".equals(num1) || "0".equals(num2))
            return "0";

        // Perform multiplication by the non-intuitive way
        final int len1 = num1.length(), len2 = num2.length();
        int[] result = new int[len1 + len2];

        for (int n = 0, sum = 0; n < len1 + len2; n++, sum /= 10) {
            for (int i = 0, j = n; i <= n; i++, j--) {
                int digit1 = i >= len1 ? 0 : (num1.charAt(len1 - 1 - i) - '0');
                int digit2 = j >= len2 ? 0 : (num2.charAt(len2 - 1 - j) - '0');
                sum += digit1 * digit2;
            }
            result[len1 + len2 - 1 - n] = sum % 10;
        }

        // Find the first non-zero number from the end of the result array
        int i = 0;
        while (i < len1 + len2 - 1 && result[i] == 0)
            i++;

        // Format result chars into String
        StringBuilder builder = new StringBuilder();
        for (; i < len1 + len2; i++)
            builder.append(result[i]);
        return builder.toString();
    }

}
