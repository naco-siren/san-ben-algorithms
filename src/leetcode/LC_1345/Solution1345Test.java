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

    @Test
    public void test_15() {
        assertEquals(3, new Solution1345().minJumps(new int[]{11,22,7,7,7,7,7,7,7,22,13}));
    }

    @Test
    public void test_29_shorter() {
        int[] input = new int[10];
        Arrays.fill(input, 7);
        input[0] = 111;
        assertEquals(2, new Solution1345().minJumps(input));
    }

    @Test
    public void test_27_full() {
        int[] input = new int[50000];
        Arrays.fill(input, 7);
        assertEquals(1, new Solution1345().minJumps(input));
    }

    @Test
    public void test_29_full() {
        int[] input = new int[50000];
        Arrays.fill(input, 7);
        input[0] = 11;
        assertEquals(2, new Solution1345().minJumps(input));
    }
}
