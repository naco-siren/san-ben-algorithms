package leetcode.LC_091;

/**
 * 91. Decode Ways
 */
class Solution91 {
    int numDecodings(String s) {
        // Initialize a DP array to memorize possible decode ways so far
        int pre2 = 1;    // The empty string can only have one decoding way
        int pre1 = s.charAt(0) == '0' ? 0 : 1;

        // Iterate through the input string and discuss different cases
        for (int i = 1; i < s.length(); i++) {
            final char ch = s.charAt(i);
            int cur = 0;

            // If current digit and previous digit makes sense
            if (s.charAt(i - 1) == '1'
                    || (s.charAt(i - 1) == '2' && ch <= '6')) {
                cur += pre2;
            }

            // If current digit it self makes sense
            if (ch > '0') {
                cur += pre1;
            }

            pre2 = pre1;
            pre1 = cur;
        }

        return pre1;
    }

    int numDecodingsArr(String s) {
        // Initialize a DP array to memorize possible decode ways so far
        final int[] ways = new int[s.length() + 1];
        ways[0] = 1;    // The empty string can only have one decoding way
        ways[1] = s.charAt(0) == '0' ? 0 : 1;

        // Iterate through the input string and discuss different cases
        for (int i = 1; i < s.length(); i++) {
            final char ch = s.charAt(i);

            // If current digit and previous digit makes sense
            if (s.charAt(i - 1) == '1'
                    || (s.charAt(i - 1) == '2' && ch <= '6')) {
                ways[i + 1] += ways[i - 1];
            }

            // If current digit it self makes sense
            if (ch > '0') {
                ways[i + 1] += ways[i];
            }
        }

        return ways[s.length()];
    }
}
