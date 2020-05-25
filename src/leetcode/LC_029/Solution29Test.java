package leetcode.LC_029;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution29Test {

    @Test
    public void divide_1_1() {
        assertEquals(1, new Solution29().divide(1, 1));
    }

    @Test
    public void divide_1_0() {
        assertEquals(Integer.MAX_VALUE, new Solution29().divide(1, 0));
    }

    @Test
    public void divide_7_3() {
        assertEquals(2, new Solution29().divide(7, 3));
    }

    @Test
    public void divide_3_7() {
        assertEquals(0, new Solution29().divide(3, 7));
    }

    @Test
    public void divide_37_5() {
        assertEquals(7, new Solution29().divide(37, 5));
    }

    @Test
    public void divide_7_4() {
        assertEquals(1, new Solution29().divide(7, 4));
    }

    @Test
    public void divide_1_m1() {
        assertEquals(-1, new Solution29().divide(1, -1));
    }

    @Test
    public void divide_m1_1() {
        assertEquals(-1, new Solution29().divide(-1, 1));
    }

    @Test
    public void divide_m7_m4() {
        assertEquals(1, new Solution29().divide(-7, -4));
    }

    @Test
    public void divide_m2147483647_m1() {
        assertEquals(2147483647, new Solution29().divide(-2147483647, -1));
    }

    @Test
    public void divide_m2147483648_m1() {
        assertEquals(2147483647, new Solution29().divide(-2147483648, -1));
    }
}