package leetcode.LC_1492;

import java.util.*;

/**
 * 1492. The kth Factor of n
 */
public class Solution1492 {
    public static int kthFactor(int n, int k) {
        final int sqrt = (int) Math.sqrt(n);

        List<Integer> divisors = new ArrayList<>();
        for (int val = 1; val <= sqrt; val++)
            if (n % val == 0)
                divisors.add(val);

        // Handle corner case where the max divisor smaller than `sqrt(n)` is exactly "the sqrt of n"
        final boolean sqrtDup = sqrt * sqrt == n;
        if (k > divisors.size() * 2 - (sqrtDup ? 1 : 0))
            return -1;

        // If `k` is within the divisors smaller than `sqrt(n)`
        for (Integer divisor : divisors) {
            k--;
            if (k == 0)
                return divisor;
        }

        // Otherwise, count it in the divisors larger than `sqrt(n)` in a reversed order
        return n / divisors.get(divisors.size() - k);
    }
}
