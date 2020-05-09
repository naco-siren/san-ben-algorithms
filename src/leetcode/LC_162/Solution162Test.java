package leetcode.LC_162;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution162Test {

    @Test
    public void findPeakElement_2_1() {
        assertEquals(0, new Solution162().findPeakElement(new int[]{2,1}));
    }

    @Test
    public void findPeakElement_1_2_3_1() {
        assertEquals(2, new Solution162().findPeakElement(new int[]{1,2,3,1}));
    }

    @Test
    public void findPeakElement_1_2_1_3_5_6_4() {
        final int result = new Solution162().findPeakElement(new int[]{1,2,1,3,5,6,4});
        assertTrue(result == 1 || result == 5);
    }
}