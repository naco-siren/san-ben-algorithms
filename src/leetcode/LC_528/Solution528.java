package leetcode.LC_528;

import java.util.Random;

/**
 * 528. Random Pick with Weight
 */
public class Solution528 {
    int N;
    int[] cumW;
    int sumW;
    Random random;

    public Solution528(int[] w) {
        this.N = w.length;
        this.cumW = new int[N];

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += w[i];
            cumW[i] = sum;
        }
        this.sumW = sum;
        this.random = new Random();
    }

    public int pickIndex() {
        int r = random.nextInt(sumW);

        // Binary search to find the `index` lo where `cumW[lo] == ceiling(r)`.
        int lo = 0, hi = N - 1;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (r >= cumW[mi]) {    // Per the comment in `pickIndex2` below, even `r == cumW[mid]` is still our of boundary.
                lo = mi + 1;
            } else {                // However, when `r < cumW[mid]`, `mid` might still be exactly our target (i.e. largest)
                hi = mi;
            }
        }
        return lo;
    }

//    public int pickIndex2() {
//        int r = random.nextInt(sumW);
//        for (int i = 0; i < N; i++) {
//            // PAY ATTENTION TO THIS `>` instead of `>=`,
//            // this is because `nextInt(sumW)` returns {0, 1, 2, ..., sumW - 1}.
//            //
//            // Take w = {1, 3} as example:
//            //
//            // cumW = {1, 4}
//            // sum = 4
//            //
//            // Since nextInt returns {0, 1, 2, 3}, we want `0` to fall into index 0, while `1`, `2`, `3` fall into index 1.
//            //
//            if (cumW[i] > r) {
//                return i;
//            }
//        }
//        return -1;
//    }
}
