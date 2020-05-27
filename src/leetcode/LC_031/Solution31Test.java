package leetcode.LC_031;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution31Test {

//    @Test
//    public void nextPermutation__() {
//        final int[] arr = new int[]{};
//        new Solution31().nextPermutation(arr);
//        assertArrayEquals(new int[]{}, arr);
//    }

    @Test
    public void nextPermutation_1_2_3() {
        final int[] arr = new int[]{1,2,3};
        new Solution31().nextPermutation(arr);
        assertArrayEquals(new int[]{1,3,2}, arr);
    }

    @Test
    public void nextPermutation_1_1_5() {
        final int[] arr = new int[]{1,1,5};
        new Solution31().nextPermutation(arr);
        assertArrayEquals(new int[]{1,5,1}, arr);
    }

    @Test
    public void nextPermutation_1_5_1() {
        final int[] arr = new int[]{1,5,1};
        new Solution31().nextPermutation(arr);
        assertArrayEquals(new int[]{5,1,1}, arr);
    }

    @Test
    public void nextPermutation_3_2_1() {
        final int[] arr = new int[]{3,2,1};
        new Solution31().nextPermutation(arr);
        assertArrayEquals(new int[]{1,2,3}, arr);
    }

    @Test
    public void nextPermutation_3_4_4_3_3() {
        final int[] arr = new int[]{3,4,4,3,3};
        new Solution31().nextPermutation(arr);
        assertArrayEquals(new int[]{4,3,3,3,4}, arr);
    }

    @Test
    public void nextPermutation_1_2_5_4_3() {
        final int[] arr = new int[]{1,2,5,4,3};
        new Solution31().nextPermutation(arr);
        assertArrayEquals(new int[]{1,3,2,4,5}, arr);
    }
}