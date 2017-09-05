package leetcode;

/**
 * Created by naco_siren on 9/1/17.
 */
public class LC_29 {

    public static void main(String[] args) {
        LC_29 lc = new LC_29();

        int r = lc.divide(0, 1);


        return;
    }

    /**
     *  Reduce the problem to positive long integer to make it easier.
     *  Use long to avoid integer overflow cases.
     */
    public int divide(int dividend, int divisor) {
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

    private long ldivide(long ldividend, long ldivisor) {
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
