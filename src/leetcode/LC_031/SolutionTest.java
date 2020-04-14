package leetcode.LC_031;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void nextPermutation_0() {
        final int[] arr = new int[]{};
        Solution.nextPermutation(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void nextPermutation_1() {
        final int[] arr = new int[]{1,2,3};
        Solution.nextPermutation(arr);
        assertArrayEquals(new int[]{1,3,2}, arr);
    }

    @Test
    public void nextPermutation_2() {
        final int[] arr = new int[]{1,1,5};
        Solution.nextPermutation(arr);
        assertArrayEquals(new int[]{1,5,1}, arr);
    }

    @Test
    public void nextPermutation_3() {
        final int[] arr = new int[]{3,2,1};
        Solution.nextPermutation(arr);
        assertArrayEquals(new int[]{1,2,3}, arr);
    }

    @Test
    public void nextPermutation_4() {
        final int[] arr = new int[]{3,4,4,3,3};
        Solution.nextPermutation(arr);
        assertArrayEquals(new int[]{4,3,3,3,4}, arr);
    }
}