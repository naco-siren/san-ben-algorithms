package leetcode.LC_171;

public class Solution {
    public static void main(String[] args) {
        int r1 = titleToNumber("A");    // 1
        int r2 = titleToNumber("AB");   // 28
        int r3 = titleToNumber("ZY");   // 701
        int r4 = titleToNumber("AAA");   // 703
    }

    public static int titleToNumber(String s) {
        int sum = 0, base = 1;
        for (int i = s.length() - 1; i >= 0; i--, base *= 26) {
            int digit = s.charAt(i) - 'A' + 1;
            sum += digit * base;
        }
        return sum;
    }
}
