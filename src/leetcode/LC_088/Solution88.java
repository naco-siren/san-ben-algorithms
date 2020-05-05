package leetcode.LC_088;

/**
 * 88. Merge Sorted Array
 */
class Solution88 {
    void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 || j >= 0) {
            final int num1 = i >= 0 ? nums1[i] : Integer.MIN_VALUE;
            final int num2 = j >= 0 ? nums2[j] : Integer.MIN_VALUE;
            if (num1 > num2) {
                nums1[k--] = num1;
                i--;
            } else {
                nums1[k--] = num2;
                j--;
            }
        }
    }
}
