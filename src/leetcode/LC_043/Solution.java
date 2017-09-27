package leetcode.LC_043;

/**
 * Created by naco_siren on 8/17/17.
 */
public class Solution {
    public static void main(String[] args) {

        String r1 = multiply("0", "9");
        String r2 = multiply("9", "9");
        String r3 = multiply("25", "4");
        String r4 = multiply("999", "99");

        return;
    }


    public static String multiply(String num1, String num2) {
        if(num1 == null || num2 == null)
            return null;
        int len1 = num1.length();
        int len2 = num2.length();

        int[] result = new int[len1 + len2];
        // Arrays.fill(result, -1);

        for (int n = 0, sum = 0; n < len1 + len2; n++, sum /= 10) {
            for (int i = 0, j = n; i <= n; i++, j--) {
                int digit1 = i >= len1 ? 0 : (num1.charAt(len1 - 1 - i) - '0');
                int digit2 = j >= len2 ? 0 : (num2.charAt(len2 - 1 - j) - '0');
                sum += digit1 * digit2;
            }
            result[len1 + len2 - 1 - n] = sum % 10;
        }

        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (i < len1 + len2 - 1 && result[i] == 0) i++;
        for (; i < len1 + len2; i++)
            builder.append(result[i]);
        return builder.toString();

    }
}
