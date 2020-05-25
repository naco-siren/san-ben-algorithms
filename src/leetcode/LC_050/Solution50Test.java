package leetcode.LC_050;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution50Test {

    @Test
    public void myPow_2_INTEGER_MIN() {
        assertEquals(0, new Solution50().myPow(2.00000, -2147483648), 0.000001);
    }

    @Test
    public void myPow_2_10() {
        assertEquals(1024, new Solution50().myPow(2.00000, 10), 0.000001);
    }
}