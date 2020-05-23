package leetcode.LC_161;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution161Test {

    @Test
    public void isOneEditDistance__() {
        assertFalse(new Solution161().isOneEditDistance("", ""));
    }
    @Test
    public void isOneEditDistance_ab_ab() {
        assertFalse(new Solution161().isOneEditDistance("ab", "ab"));
    }

    @Test
    public void isOneEditDistance_a_() {
        assertTrue(new Solution161().isOneEditDistance("a", ""));
    }

    @Test
    public void isOneEditDistance_ab_acb() {
        assertTrue(new Solution161().isOneEditDistance("ab", "acb"));
    }

    @Test
    public void isOneEditDistance_cab_ad() {
        assertFalse(new Solution161().isOneEditDistance("cab", "ad"));
    }

    @Test
    public void isOneEditDistance_1203_1213() {
        assertTrue(new Solution161().isOneEditDistance("1203", "1213"));
    }
}