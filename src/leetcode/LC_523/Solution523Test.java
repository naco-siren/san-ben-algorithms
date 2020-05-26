package leetcode.LC_523;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution523Test {

    @Test
    public void checkSubarraySum_23_2_4_6_7__6() {
        assertTrue(new Solution523().checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
    }

    @Test
    public void checkSubarraySum_23_2_6_4_7__6() {
        assertTrue(new Solution523().checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
    }
}