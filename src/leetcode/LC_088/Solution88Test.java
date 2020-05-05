package leetcode.LC_088;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution88Test {

    @Test
    public void merge_1() {
        final int[] nums1 = new int[]{1,2,3,0,0,0};
        final int m = 3;

        final int[] nums2 = new int[]{2,5,6};
        final int n = 3;

        new Solution88().merge(nums1, m, nums2, n);

        assertArrayEquals(new int[]{1,2,2,3,5,6}, nums1);
    }
}