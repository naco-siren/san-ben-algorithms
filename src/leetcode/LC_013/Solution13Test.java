package leetcode.LC_013;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution13Test {

    @Test
    public void romanToInt_III() {
        assertEquals(3, new Solution13().romanToInt("III"));
    }

    @Test
    public void romanToInt_IV() {
        assertEquals(4, new Solution13().romanToInt("IV"));
    }

    @Test
    public void romanToInt_IX() {
        assertEquals(9, new Solution13().romanToInt("IX"));
    }

    @Test
    public void romanToInt_LVIII() {
        assertEquals(58, new Solution13().romanToInt("LVIII"));
    }

    @Test
    public void romanToInt_MCMXCIV() {
        assertEquals(1994, new Solution13().romanToInt("MCMXCIV"));
    }
}