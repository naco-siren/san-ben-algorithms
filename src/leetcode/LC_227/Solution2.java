package leetcode.LC_227;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution1 = new Solution2("3+2*2");
        int r1 = solution1.calculate();       // 7

        Solution2 solution2 = new Solution2(" 3/2 ");
        int r2 = solution2.calculate();       // 1

        Solution2 solution3 = new Solution2(" 3+5 / 2 ");
        int r3 = solution3.calculate();   // 5
    }

    public Solution2(String s) {
        _str = "+" + s + "+";
    }

    private String _str;
    private int _cursor;

    public int calculate() {
        int total = 0, term = 0;

        char op;

        _cursor = 0;
        while (_cursor < _str.length()) {
            skipBlankChars();
            op = _str.charAt(_cursor);

            if (op == '+' || op == '-') {
                total += term;

                _cursor++;
                skipBlankChars();
                term = readInteger();
                term = op == '+' ? term : -term;

            } else {
                _cursor++;
                skipBlankChars();
                int n = readInteger();
                term = op == '*' ? term * n : term / n;
            }
        }
        return total;
    }

    private void skipBlankChars() {
        while (_cursor < _str.length() && Character.isSpaceChar(_str.charAt(_cursor)))
            _cursor++;
    }

    private int readInteger() {
        int num = 0;
        while (_cursor < _str.length() && Character.isDigit(_str.charAt(_cursor)))
            num = num * 10 + (_str.charAt(_cursor++) - '0');
        return num;
    }
}
