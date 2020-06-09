package leetcode.LC_128;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution128Test {

    @Test
    public void longestConsecutiveSequence_0_3_7_2_5_8_4_6_0_1() {
        assertEquals(9, new Solution128().longestConsecutiveSequence(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

    @Test
    public void longestConsecutiveSequence_0_2_5_8_4_6_1() {
        assertEquals(3, new Solution128().longestConsecutiveSequence(new int[]{0,2,5,8,4,6,1}));
    }

    @Test
    public void longestConsecutiveSequence_0_2_5_8_4_6_1_3() {
        assertEquals(7, new Solution128().longestConsecutiveSequence(new int[]{0,2,5,8,4,6,1,3}));
    }
}