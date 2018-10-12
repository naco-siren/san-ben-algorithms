package leetcode.LC_168;

public class Solution {
    public static void main(String[] args) {
        String r1 = convertToTitle(1);      // "A"
        String r2 = convertToTitle(28);     // "AB"
        String r3 = convertToTitle(701);    // "ZY"
        String r4 = convertToTitle(703);    // "AAA"
    }

    public static String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        while (n > 0) {
            builder.append((char) (--n % 26 + 'A'));
            n /= 26;
        }
        return builder.reverse().toString();
    }
}
