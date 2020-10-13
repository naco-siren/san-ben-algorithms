package leetcode.LC_227;

/**
 * 227. Basic Calculator II
 */
public class Solution227 {

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
                // Checkout pervious term's value
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
