package leetcode.LC_896;

/**
 * 896. Monotonic Array
 */
class Solution896 {
    boolean isMonotonic(int[] A) {
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
