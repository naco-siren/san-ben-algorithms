package leetcode.LC_896;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution896Test {


    @Test
    public void isMonotonic_1_1() {
        assertTrue(new Solution896().isMonotonic(new int[]{1,1}));
    }

    @Test
    public void isMonotonic_1_2_2_3() {
        assertTrue(new Solution896().isMonotonic(new int[]{1,2,2,3}));
    }


    @Test
    public void isMonotonic_6_5_4_4() {
        assertTrue(new Solution896().isMonotonic(new int[]{6,5,4,4}));
    }


    @Test
    public void isMonotonic_1_3_2() {
        assertFalse(new Solution896().isMonotonic(new int[]{1,3,2}));
    }


    @Test
    public void isMonotonic_1_2_4_5() {
        assertTrue(new Solution896().isMonotonic(new int[]{1,2,4,5}));
    }
}