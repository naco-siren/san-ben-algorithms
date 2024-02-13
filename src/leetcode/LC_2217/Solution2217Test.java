package leetcode.LC_2217;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Solution2217Test {

    @Test
    public void sample_0() {
        long[] result = new Solution2217().kthPalindrome(new int[]{1,2,3,4,5,90}, 3);
        long[] expected = new long[]{101,111,121,131,141,999};
        assertArrayEquals(expected, result);
    }

    @Test
    public void sample_1() {
        long[] result = new Solution2217().kthPalindrome(new int[]{2,4,6}, 4);
        long[] expected = new long[]{1111, 1331, 1551};
        assertArrayEquals(expected, result);
    }
}
