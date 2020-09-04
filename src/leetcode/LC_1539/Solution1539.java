package leetcode.LC_1539;

/**
 * 1539. Kth Missing Positive Number
 */
public class Solution1539 {
    public int findKthPositive(int[] arr, int k) {
        int counter = 1;
        int i = 0;

        while (k > 0) { // Even if `k` is 1 based index, you still have to make sure that `k` has been counted four
            if (i < arr.length && arr[i] == counter) {
                i++;
            } else {
                k--;
            }
            counter++;
        }
        return counter - 1;     // ... and then take 1 step back.

        // Otherwise, it cannot handle the corner case of `k == 1`,
        // because the counter w/ initial value of 1 will be returned immediately, e.g. {1, 2, 3}, k = 1.
    }
}
