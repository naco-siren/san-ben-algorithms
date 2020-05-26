package leetcode.LC_005;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution005Test {

    @Test
    public void longestPalindrome_babad() {
        assertEquals("bab", new Solution005().longestPalindrome("babad"));
    }

    @Test
    public void longestPalindrome_cbabab() {
        assertEquals("babab", new Solution005().longestPalindrome("cbabab"));
    }

}