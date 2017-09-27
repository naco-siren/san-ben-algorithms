package leetcode.LC_008;

/**
 * Created by naco_siren on 7/8/17.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.myAtoi("9223372036854775809");

        int tenth = Integer.MAX_VALUE / 10;
        int by8 = tenth * 8;

        return;
    }

    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        str = str.trim();

        int i = 0;
        int len = str.length();
        char[] chars = str.toCharArray();

        boolean isNeg = false;
        if (chars[i] == '-') {
            isNeg = true;
            i++;
        } else if (chars[i] == '+') {
            i++;
        }

        int absVal = 0;
        while (i < len) {
            int digit = charToInt(chars[i]);
            if (digit == -1) {
                return returnResult(absVal, isNeg);
            }
            else {
                absVal *= 10;
                absVal += digit;
            }
            i++;
        }
        return returnResult(absVal, isNeg);
    }

    private int charToInt(char ch) {
        if (ch >= '0' && ch <= '9')
            return ch - '0';
        else
            return -1;
    }

    private int returnResult(int absVal, boolean isNeg) {
        absVal = isNeg ? -absVal : absVal;
        if (absVal > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (absVal < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else
            return (int) absVal;
    }

}
