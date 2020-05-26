package leetcode.LC_091;

/**
 * 91. Decode Ways
 */
class Solution91 {
    int numDecodings(String s) {
        // Initialize a DP array to memorize possible decode ways so far
        int pre2 = 1;                                               // The empty string can only have one decoding way
        int pre1 = s.charAt(0) == '0' ? 0 : 1;                      // Substring s[0:1] (of size 1) has to be non-zero, otherwise "0" has no decoding ways!

        // Iterate through the input string and discuss different cases
        for (int i = 1; i < s.length(); i++) {
            final char preCh = s.charAt(i - 1);
            final char curCh = s.charAt(i);

            int cur = 0;

            // If current digit and previous digit makes sense
            if (preCh == '1' || (preCh == '2' && curCh <= '6'))
                cur += pre2;
                                                                    // DONT USE IF/ELSE, BECAUSE THESE TWO CASES MAY COEXIST
            // If current digit it self makes sense
            if (curCh > '0')
                cur += pre1;

            pre2 = pre1;
            pre1 = cur;
        }

        return pre1;                    // Note that `cur` is only a local variable within the for-loop's scope.
    }

    int numDecodingsArr(String s) {
        // Initialize a DP array to memorize possible decode ways so far
        final int[] ways = new int[s.length() + 1];
        ways[0] = 1;                                                // The empty string can ONLY have one decoding way.
        ways[1] = s.charAt(0) == '0' ? 0 : 1;                       // Substring s[0:1] (of size 1) has to be non-zero, otherwise "0" has no decoding ways!

        // Iterate through the input string and discuss different cases
        for (int i = 1; i < s.length(); i++) {
            final char pre = s.charAt(i - 1);
            final char cur = s.charAt(i);

            // If current digit and previous digit makes sense
            if (pre == '1' || (pre == '2' && cur <= '6'))
                ways[i + 1] += ways[i - 1];
                                                                    // DONT USE IF/ELSE, BECAUSE THESE TWO CASES MAY COEXIST
            // Meanwhile, if current digit it self makes sense
            if (cur > '0')
                ways[i + 1] += ways[i];
        }

        return ways[s.length()];
    }
}
