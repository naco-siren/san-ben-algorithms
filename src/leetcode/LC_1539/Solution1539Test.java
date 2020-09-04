package leetcode.LC_1539;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution1539Test {

    @Test
    public void findKthPositive_1_2_3_4__1() {
        assertEquals(5, new Solution1539().findKthPositive(new int[]{1,2,3,4}, 1));
    }

    @Test
    public void findKthPositive_1_2_3_4__2() {
        assertEquals(6, new Solution1539().findKthPositive(new int[]{1,2,3,4}, 2));
    }

    @Test
    public void findKthPositive_2_3_4_7_11__5() {
        assertEquals(9, new Solution1539().findKthPositive(new int[]{2,3,4,7,11}, 5));
    }

    @Test
    public void findKthPositive_2_3_4_6_7_11__5() {
        assertEquals(10, new Solution1539().findKthPositive(new int[]{2,3,4,6,7,11}, 5));
    }

}