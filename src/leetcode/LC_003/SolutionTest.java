package leetcode.LC_003;

import org.junit.Test;

import static leetcode.LC_003.Solution.lengthOfLongestSubstring;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void lengthOfLongestSubstring_a() {
        assertEquals(1, lengthOfLongestSubstring("a"));
    }

    @Test
    public void lengthOfLongestSubstring_aw() {
        assertEquals(2, lengthOfLongestSubstring("aw"));
    }

    @Test
    public void lengthOfLongestSubstring_abac() {
        assertEquals(3, lengthOfLongestSubstring("abac"));
    }

    @Test
    public void lengthOfLongestSubstring_abcbda() {
        assertEquals(4, lengthOfLongestSubstring("abcbda"));
    }

    @Test
    public void lengthOfLongestSubstring_abcabcbb() {
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    public void lengthOfLongestSubstring_abbcdb() {
        assertEquals(3, lengthOfLongestSubstring("abbcdb"));
    }

    @Test
    public void lengthOfLongestSubstring_bbbbb() {
        assertEquals(1, lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    public void lengthOfLongestSubstring_wtf() {
        assertEquals(55, lengthOfLongestSubstring("hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"));
    }
}
