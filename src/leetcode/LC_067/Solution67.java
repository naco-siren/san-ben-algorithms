package leetcode.LC_067;

/**
 * 67. Add Binary
 */
class Solution67 {
    String addBinary(String a, String b) {
        // Handle corner cases and place longer string at `a`
        final int M = a.length(), N = b.length();
        if (M < N)
            return addBinary(b, a);

        // Perform addition
        StringBuilder builder = new StringBuilder();
        int k = 0, carry = 0;
        while (carry > 0 || k < M) {
            final int i = M - 1 - k, j = N - 1 - k;
            final int first = i >= 0 ? a.charAt(i) - '0' : 0;
            final int second = j >= 0 ? b.charAt(j) - '0' : 0;
            final int sum = first + second + carry;

            switch (sum) {
                case 0:
                    builder.append('0');
                    carry = 0;
                    break;
                case 1:
                    builder.append('1');
                    carry = 0;
                    break;
                case 2:
                    builder.append('0');
                    carry = 1;
                    break;
                case 3:
                    builder.append('1');
                    carry = 1;
                    break;
                default:
                    throw new IllegalStateException("sum is not expected to be: " + sum);
            }

            k++;
        }
        return builder.reverse().toString();
    }
}
