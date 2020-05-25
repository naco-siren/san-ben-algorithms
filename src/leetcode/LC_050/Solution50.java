package leetcode.LC_050;

/**
 * 50. Pow(x, n)
 */
class Solution50 {
    double myPow(double x, int n) {
        long N = n;     // Use `long` here to cope with overflow corner case: `n = Integer.MIN_VALUE`, which cannot be directly applied with `n = -n`
                        // Refer to unit test "myPow_2_INTEGER_MIN".

        if (N == 0)
            return 1;

        if (N < 0) {
            x = 1 / x;
            N = -N;     // This is why we need a `long` `N`.
        }

        return fastPow(x, N);
    }

    /*
     *
     *
     * 3 ^ 7 = 3 ^ 1 * 3 ^ 2 * 3 ^ 4, where 7 = 111b.
     * 7 ^ 5 = 7 ^ 1 * 7 ^ 0 * 7 ^ 4, where 5 = 101b.
     *
     *
     */
    private double fastPow(double x, long n) {
        double multiplier = x, result = 1;
        while (n > 0) {
            // See examples above!
            if ((n & 1) == 1) {
//            if (n % 2 == 1)
                result *= multiplier;
            }

            multiplier *= multiplier;
            n >>= 1;
        }
        return result;
    }

    private double fastPow2(double x, long n) {

        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
