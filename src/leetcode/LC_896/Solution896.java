package leetcode.LC_896;

/**
 * 896. Monotonic Array
 */
class Solution896 {
    boolean isMonotonic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] > A[i+1])
                increasing = false;
            if (A[i] < A[i+1])
                decreasing = false;
        }

        return increasing || decreasing;
    }

    boolean isMonotonic2(int[] A) {
        if (A.length == 1)
            return true;

        boolean expectAscending = A[A.length - 1] >= A[0];

        for (int i = 1; i < A.length; i++) {
            if (expectAscending && A[i] < A[i - 1]) {
                return false;
            } else if (!expectAscending && A[i] > A[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
