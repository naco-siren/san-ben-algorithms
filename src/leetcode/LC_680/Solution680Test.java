package leetcode.LC_680;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution680Test {

    @Test
    public void validPalindrome_aba() {
        assertTrue(new Solution680().validPalindrome("aba"));
    }

    @Test
    public void validPalindrome_abba() {
        assertTrue(new Solution680().validPalindrome("abba"));
    }

    @Test
    public void validPalindrome_abca() {
        assertTrue(new Solution680().validPalindrome("abca"));
    }

    @Test
    public void validPalindrome_ebcbbececabbacecbbcbe() {
        assertTrue(new Solution680().validPalindrome("ebcbbececabbacecbbcbe"));
    }
}