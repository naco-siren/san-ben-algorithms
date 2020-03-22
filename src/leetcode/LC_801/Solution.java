package leetcode.LC_801;

/**
 * 801. Minimum Swaps To Make Sequences Increasing
 *
 * We have two integer sequences A and B of the same non-zero length.
 *
 * We are allowed to swap elements A[i] and B[i].  Note that both elements are in the same index position in their respective sequences.
 *
 * At the end of some number of swaps, A and B are both strictly increasing.  (A sequence is strictly increasing if and only if A[0] < A[1] < A[2] < ... < A[A.length - 1].)
 *
 * Given A and B, return the minimum number of swaps to make both sequences strictly increasing.  It is guaranteed that the given input always makes it possible.
 *
 * Example:
 * Input: A = [1,3,5,4], B = [1,2,3,7]
 * Output: 1
 * Explanation:
 * Swap A[3] and B[3].  Then the sequences are:
 * A = [1, 3, 5, 7] and B = [1, 2, 3, 4]
 * which are both strictly increasing.
 * Note:
 *
 * A, B are arrays with the same length, and that length will be in the range [1, 1000].
 * A[i], B[i] are integer values in the range [0, 2000].
 *
 */
public class Solution {
    public int minSwap(int[] A, int[] B) {
        // Global min swaps count. `original`: keep A[i] & B[i], `swapped`: swap A[i] & B[i]
        int original = 0, swapped = 1;

        // Case `i = 0` is already handled by `swapped = 1`
        for (int i = 1; i < A.length; i++) {
            // Since `original` and `swapped` refers to global state before current `i`,
            // we need two temp vars to save the min swaps count, and assign them to global mins at the end.
            int original2 = Integer.MAX_VALUE, swapped2 = Integer.MAX_VALUE;

            /**
             *  All the `Math.min` here is equal to:
             *
             *  if (global + 1 < temp)
             *      temp = global + 1;
             */

            // When keeping is feasible:
            if (A[i-1] < A[i] && B[i-1] < B[i]) {
                original2 = Math.min(original2, original);  // To keep `i`, previous `original` is already okay.
                swapped2 = Math.min(swapped2, swapped + 1); // To keep `i`, previous `swapped` needs another swap here.
            }

            /* Note that these two cases are not conflicted, and therefore cannot use `else if`. */

            // When swapping is feasible:
            if (A[i-1] < B[i] && B[i-1] < A[i]) {
                original2 = Math.min(original2, swapped);   // To swap `i`, previous `swapped` is already okay.
                swapped2 = Math.min(swapped2, original + 1);// To swap `i`, previous `original` needs another swap here.
            }

            original = original2;
            swapped = swapped2;
        }
        return Math.min(original, swapped);
    }
}
