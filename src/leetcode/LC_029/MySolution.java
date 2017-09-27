package leetcode.LC_029;

/**
 * Created by naco_siren on 9/1/17.
 */
public class MySolution {

    public static void main(String[] args) {
        int r0 = divide(1, 1);// 1
        int r1 = divide(1, 0); //Integer.MAX_VALUE
        int r2 = divide(1, 1); //1
        int r3 = divide(3, 7); // 0
        int r4 = divide(37, 5); // 7

        int r5 = divide(7, 4); // 1
        int r6 = divide(-7, -4); // 1
        int r7 = divide(1, 1); // -1

        return;
    }

    public static int divide(int dividend, int divisor) {
        /* Corner case */
        if (divisor == 0) return Integer.MAX_VALUE;

        /* Determine signal */
        boolean sign0 = dividend >> 31 == 0 ? true : false;
        boolean sign1 = divisor >> 31 == 0 ? true : false;
        boolean isNeg = sign0 ^ sign1;
        long op1 = Math.abs((long) dividend), op2 = Math.abs((long) divisor);

        /* Prune */
        if (op1 < op2) return 0;

        /* Find the largest multiple below dividend */
        long multiple = op2, count = 1;
        do {
            multiple += multiple;
            count += count;
        } while (multiple <= op1);
        multiple >>= 1; count >>= 1;

        /* Logarithmically subtract from dividend */
        long quotient = 0;
        while (count > 0) {
            if (op1 >= multiple) {
                op1 -= multiple;
                quotient += count;
            }
            multiple >>= 1; count >>= 1;
        }

        /* Handle overflow */
        int retval;
        if (quotient <= Integer.MAX_VALUE)
            retval = isNeg == true ? (int) -quotient : (int) quotient;
        else
            retval = isNeg == true ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        return retval;
    }
}
