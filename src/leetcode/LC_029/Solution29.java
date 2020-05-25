package leetcode.LC_029;

import java.util.ArrayList;

/**
 * 29. Divide Two Integers
 */
public class Solution29 {

    /*
     *
     * My Approach: Subtracting powers of two + promote integer to long.
     *
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     *
     */
    int divide(int dividend, int divisor) {
        /* Corner case */
        if (divisor == 0) return Integer.MAX_VALUE;

        /* Determine signal, then keep only the absolute values as ops */
        boolean isPos0 = dividend >> 31 == 0;                   // PAY ATTENTION TO `31` here! DO NOT USE 32
        boolean isPos1 = divisor >> 31 == 0;
        boolean isNeg = isPos0 ^ isPos1;
        long op1 = Math.abs((long) dividend), op2 = Math.abs((long) divisor);

        /* Early return */
        if (op1 < op2)
            return 0;

        /* Find the largest multiple below dividend by 2's exponents */
        long multiple = op2, count = 1;     // DO NOT use `int` for `count` here, because it will overflow when op2 is too small.
        while (multiple <= op1) {           // Refer to "divide_m2147483648_m1" case.
            multiple *= 2;
            count *= 2;
        }
        multiple >>= 1; count >>= 1;

        // Will also do but deprecated
//        do {
//            multiple *= 2;
//            count *= 2;
//        } while (multiple <= op1);
//        multiple >>= 1; count >>= 1;

        /* Logarithmically subtract from dividend */
        long quotient = 0;
        while (count > 0) {             // Note condition here is NOT `op1 > 0`, BUT `count > 0` instead!!!
            // This check is because remaining `op1` is not guaranteed to be always larger than `multiples` then,
            // e.g. op1 = 3 + 8 * 3 = 27, op2 = 3, multiple = 24, count = 8.  (see? `multiple = count * op2` now)
            //      First round:    27 >= 24,   op1 = 27 - 24 = 3,  quotient = 0 + 8 = 8,   count = 8 << 1 = 4;
            //      Second round:   3 < 12,     nothing,                                    count = 4 << 1 = 2;
            //      Third round:    3 < 6,      nothing,                                    count = 2 << 1 = 1;
            //      Fourth round:   3 >= 3,     op1 = 3 - 3 = 0,    quotient = 8 + 1 = 9,   count = 1 << 1 = 0;
            if (op1 >= multiple) {
                op1 -= multiple;
                quotient += count;
            }
            multiple >>= 1; count >>= 1;
        }

        /* Handle overflow */
        if (quotient <= Integer.MAX_VALUE) {
            return isNeg ? (int) -quotient : (int) quotient;
        } else {
            return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }


    /*
     *
     *
     * Approach #1: Adding Powers of Two
     *
     * Time Complexity: O(log N)
     * Space Complexity: O(1)
     *
     */
    private static int HALF_INT_MIN = -1073741824;// -2**30;
    public int divide1(int dividend, int divisor) {
        // Special case: overflow.
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        /* We need to convert both numbers to negatives.
         * Also, we count the number of negatives signs. */
        int negatives = 2;
        if (dividend > 0) {
            negatives--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negatives--;
            divisor = -divisor;
        }

        ArrayList<Integer> doubles = new ArrayList<>();
        ArrayList<Integer> powersOfTwo = new ArrayList<>();

        /* Nothing too exciting here, we're just making a list of doubles of 1 and
         * the divisor. This is pretty much the same as Approach 2, except we're
         * actually storing the values this time. */
        int powerOfTwo = -1;
        while (divisor >= dividend) {
            doubles.add(divisor);
            powersOfTwo.add(powerOfTwo);
            // Prevent needless overflows from occurring...
            if (divisor < HALF_INT_MIN) {
                break;
            }
            divisor += divisor;
            powerOfTwo += powerOfTwo;
        }

        int quotient = 0;
        /* Go from largest double to smallest, checking if the current double fits.
         * into the remainder of the dividend. */
        for (int i = doubles.size() - 1; i >= 0; i--) {
            if (doubles.get(i) >= dividend) {
                // If it does fit, add the current powerOfTwo to the quotient.
                quotient += powersOfTwo.get(i);
                // Update dividend to take into account the bit we've now removed.
                dividend -= doubles.get(i);
            }
        }

        /* If there was originally one negative sign, then
         * the quotient remains negative. Otherwise, switch
         * it to positive. */
        if (negatives != 1) {
            return -quotient;
        }
        return quotient;
    }


    /**
     *
     *
     *
     *  Approach #4: Long.
     *
     *  1. Reduce the problem to positive long integer to make it easier.
     *  2. Use long to avoid integer overflow cases.
     *
     *
     */
    int divideLong(int dividend, int divisor) {
        /* Settle the sign */
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long ldividend = Math.abs((long) dividend), ldivisor = Math.abs((long) divisor);

        /* Take care of corner cases. */
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor))	return 0;

        /* Perform long division */
        long lquotient = ldivide(ldividend, ldivisor);

        /* Handle overflow */
        int retval;
        if (lquotient > Integer.MAX_VALUE)
            retval = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        else
            retval = (int) (sign * lquotient);
        return retval;
    }

    long ldivide(long ldividend, long ldivisor) {
        /* Recursion exit condition */
        if (ldividend < ldivisor) return 0;

        // Find the largest multiple so that: { divisor * multiple <= dividend },
        // whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        // Think this as a binary search.
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        /* Look for additional value for the multiple from the reminder (dividend - sum) recursively. */
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}
