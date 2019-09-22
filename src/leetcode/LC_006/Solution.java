package leetcode.LC_006;

/**
 * Created by naco_siren on 8/22/17.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        assert solution.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR");
        assert solution.convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI");
    }

    public String convert(String s, int numRows) {
        if (s == null)
            throw new IllegalArgumentException("Invalid input string!");
        if (numRows <= 0)
            throw new IllegalArgumentException("Invalid number of rows!");

        if (numRows == 1)
            return s;

        StringBuilder builder = new StringBuilder();

        final int n = numRows;
        // Row #0
        for (int c = 0; c < s.length(); c += (2*n-2))
            builder.append(s.charAt(c));

        // Row #1 ~ #n-1
        for (int r = 1; r < n - 1; r++) {
            for (int c = r; c < s.length(); c += (2*n-2)) {
                builder.append(s.charAt(c));
                int cc = c + (n - 1 - r) + (n - 1 - r);
                if (cc < s.length())
                    builder.append(s.charAt(cc));
            }
        }

        // Row #n
        for (int c = n - 1; c < s.length(); c += (2*n-2))
            builder.append(s.charAt(c));

        return builder.toString();
    }
}
