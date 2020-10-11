package leetcode.LC_674;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution674Test {

    @Test
    public void findLengthOfLCIS_empty() {
        assertEquals(0, new Solution674().findLengthOfLCIS(new int[]{}));
    }

    @Test
    public void findLengthOfLCIS_1() {
        assertEquals(1, new Solution674().findLengthOfLCIS(new int[]{1}));
    }

    @Test
    public void findLengthOfLCIS_2_2_2() {
        assertEquals(1, new Solution674().findLengthOfLCIS(new int[]{2, 2, 2}));
    }

    @Test
    public void findLengthOfLCIS_1_3_5_7() {
        assertEquals(4, new Solution674().findLengthOfLCIS(new int[]{1, 3, 5, 7}));
    }

    @Test
    public void findLengthOfLCIS_1_3_7_4_5() {
        assertEquals(3, new Solution674().findLengthOfLCIS(new int[]{1, 3, 7, 4, 5}));
    }
}