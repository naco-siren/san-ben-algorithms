package leetcode.LC_1010;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Solution1010Test {
    @Test
    public void sample_0() {
        assertEquals(3, new Solution1010().numPairsDivisibleBy60(new int[]{30,20,150,100,40}));
    }

    @Test
    public void sample_1() {
        assertEquals(3, new Solution1010().numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }

    @Test
    public void many_60() {
        int[] input = new int[60000];
        Arrays.fill(input, 60);

        assertEquals(1799970000, new Solution1010().numPairsDivisibleBy60(input));
    }
}
