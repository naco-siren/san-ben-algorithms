package leetcode.LC_977;

/**
 * 977. Squares of a Sorted Array
 */
class Solution977 {
    int[] sortedSquares(int[] A) {
        final int N = A.length;

        // Prepare an output array and a `w` write pointer
        int[] ans = new int[N];
        int w = 0;

        // `r` is the first non-negative (zero & positive) number's index
        int r = 0;
        while (r < N && A[r] < 0)
            r++;

        // `l` is the last negative number's index
        int l = r-1;

        // If both negative subarray and positive subarray exist
        while (l >= 0 && r < N) {
            final int lS = A[l] * A[l], rS = A[r] * A[r];
            if (lS < rS) {
                ans[w++] = lS;
                l--;
            } else {
                ans[w++] = rS;
                r++;
            }
        }

        // Finish the remaining negative subarray
        while (l >= 0) {
            ans[w++] = A[l] * A[l];
            l--;
        }

        // Or, finish the remaining negative subarray
        while (r < N) {
            ans[w++] = A[r] * A[r];
            r++;
        }

        return ans;
    }
}
