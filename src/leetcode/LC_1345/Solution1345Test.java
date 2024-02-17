package leetcode.LC_1345;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Solution1345Test {
    @Test
    public void sample_0() {
        assertEquals(3, new Solution1345().minJumps(new int[]{100,-23,-23,404,100,23,23,23,3,404}));
    }

    @Test
    public void sample_1() {
        assertEquals(0, new Solution1345().minJumps(new int[]{7}));
    }

    @Test
    public void sample_2() {
        assertEquals(1, new Solution1345().minJumps(new int[]{7,6,9,6,9,6,9,7}));
    }

    // TODO: FIX MEMORY EXCEEDS LIMIT!
    @Test
    public void test_29() {
        int[] input = new int[50000];
        Arrays.fill(input, 7);
        input[0] = 11;
        assertEquals(1, new Solution1345().minJumps(input));
    }
}
