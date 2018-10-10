package leetcode.LC_227;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int r1 = solution.calculate("3+2*2");       // 7
        int r2 = solution.calculate(" 3/2 ");       // 1
        int r3 = solution.calculate(" 3+5 / 2 ");   // 5
    }

    public int calculate(String s) {
        s = "+" + s + "+";

        int total = 0, term = 0;
        char op;

        int i = 0;
        while (i < s.length()) {
            // Skip blank chars
            while (Character.isSpaceChar(s.charAt(i)))
                i++;

            // Read operator
            op = s.charAt(i);

            if (op == '+' || op == '-') {
                total += term;

                // Skip blank chars
                i++;
                while (i < s.length() && Character.isSpaceChar(s.charAt(i)))
                    i++;

                // Read current number
                term = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    term = term * 10 + (s.charAt(i++) - '0');

                term = op == '+' ? term : -term;

            } else {

                // Skip blank chars
                i++;
                while (i < s.length() && Character.isSpaceChar(s.charAt(i)))
                    i++;

                // Read next number to multiply or divide
                int n = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    n = n * 10 + (s.charAt(i++) - '0');

                term = op == '*' ? term * n : term / n;
            }
        }
        return total;
    }
}
