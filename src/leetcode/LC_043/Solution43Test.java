package leetcode.LC_043;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Solution43Test {

    @Test
    public void multiply_0_19() {
        assertEquals("0", new Solution43().multiply("0", "19"));
    }

    @Test
    public void multiply_2_3() {
        assertEquals("6", new Solution43().multiply("2", "3"));
    }

    @Test
    public void multiply_9_9() {
        assertEquals("81", new Solution43().multiply("9", "9"));
    }

    @Test
    public void multiply_2_5() {
        assertEquals("10", new Solution43().multiply("5", "2"));
    }

    @Test
    public void multiply_25_4() {
        assertEquals("100", new Solution43().multiply("25", "4"));
    }

    @Test
    public void multiply_4() {
        assertEquals("98901", new Solution43().multiply("999", "99"));
    }

    @Test
    public void multiply_5() {
        assertEquals("56088", new Solution43().multiply("123", "456"));
    }
}