package leetcode.LC_2217;

public class Solution2217 {
    // Full (even):
    // 1 0 0 0 0 0 0 1
    // [ . . ^ ^ . . ]
    //
    // Half (even):
    // 1 0 0 0      n / 2
    // [ . . ^
    //
    // Full (odd):
    // 1 0 0 0 1
    // [ . ^ . ]
    //
    // Full (even):
    // 1 0 0        ( n + 1 ) / 2
    // [ . ^

    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] results = new long[queries.length];

        boolean isOdd = (intLength & 1) == 1;
        final int halfLen = isOdd ? (intLength + 1) / 2 : intLength / 2;

        final int base = tensExponentiation(halfLen - 1);
        final int ceiling = tensExponentiation(halfLen) - 1;

        for (int i = 0; i < queries.length; i++) {
            // convert 1-based to 0-based
            final int query = queries[i] - 1;
            final int half = base + query;

            if (half > ceiling) {
                results[i] = -1;
                continue;
            }

            String halfStr = String.valueOf(half);
            String suffix;
            if (isOdd) {
                StringBuilder sb = new StringBuilder(halfStr);
                sb.setLength(halfStr.length() - 1);
                sb.reverse();
                suffix = sb.toString();
            } else {
                StringBuilder sb = new StringBuilder(halfStr);
                sb.reverse();
                suffix = sb.toString();
            }
            final String resultStr = new StringBuilder(halfStr).append(suffix).toString();
            results[i] = Long.parseLong(resultStr);
        }
        return results;
    }

    private int tensExponentiation(int power) {
        if (power < 0)
            throw new IllegalArgumentException("Expect power to be non negative!");

        int base = 1;
        while (power > 0) {
            base *= 10;
            power--;
        }
        return base;
    }
}
