package leetcode.LC_201;

/**
 * 201. Bitwise AND of Numbers Range
 */
class Solution {
    int rangeBitwiseAnd(int m, int n) {
        if (m == n)
            return m;

        if (m == 0)
            return 0;

        int result = 0;
        int a, b, t;
        while(m > 0) {
            // Calculate Log2(m) and Log2(n)
            a = (int) (Math.log(m) / Math.log(2));
            b = (int) (Math.log(n) / Math.log(2));

            if (a == b) {
                t = 1 << a;
                result += t;
                m -= t;
                n -= t;
            } else {
                break;
            }
        }
        return result;
    }
}
