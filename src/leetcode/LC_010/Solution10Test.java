package leetcode.LC_010;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution10Test {

    @Test
    public void isMatch_aa_1() {
        assertTrue(new Solution10().isMatch("aa", "a*"));
    }

    @Test
    public void isMatch_aa_2() {
        assertTrue(new Solution10().isMatch("aa", "a."));
        assertTrue(new Solution10().isMatch("aa", ".a"));
    }

    @Test
    public void isMatch_aa_3() {
        assertFalse(new Solution10().isMatch("aa", "a"));
    }

    @Test
    public void isMatch_ab() {
        assertTrue(new Solution10().isMatch("ab", ".*"));
    }

    @Test
    public void isMatch_cab() {
        assertTrue(new Solution10().isMatch("cab", "c*a*b"));
    }

    @Test
    public void isMatch_mississippi() {
        assertFalse(new Solution10().isMatch("mississippi", "mis*is*p*."));
    }
}