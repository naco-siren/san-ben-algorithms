package leetcode.LC_227;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution227Test {

    @Test
    public void calculate_0() {
        assertEquals(7, new Solution227().calculate("3+2*2"));
    }

    @Test
    public void calculate_1() {
        assertEquals(7, new Solution227().calculate(" 3 + 2 * 2 "));
    }

    @Test
    public void calculate_2() {
        assertEquals(1, new Solution227().calculate("3 /2 "));
    }

    @Test
    public void calculate_3() {
        assertEquals(5, new Solution227().calculate(" 3+5 / 2 "));
    }

}