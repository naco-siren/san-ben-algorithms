package leetcode.LC_415;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution415Test {

    @Test
    public void addStrings_0_0() {
        assertEquals("0", new Solution415().addStrings("0", "0"));
    }

    @Test
    public void addStrings_0_5() {
        assertEquals("5", new Solution415().addStrings("0", "5"));
    }

    @Test
    public void addStrings_5_12() {
        assertEquals("17", new Solution415().addStrings("5", "12"));
    }

    @Test
    public void addStrings_1_9() {
        assertEquals("10", new Solution415().addStrings("1", "9"));
    }

    @Test
    public void addStrings_96_9() {
        assertEquals("105", new Solution415().addStrings("96", "9"));
    }
}