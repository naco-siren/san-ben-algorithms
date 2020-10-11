package leetcode.LC_151;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution151Test {

    @Test
    public void reverseWords_the_sky_is_blue() {
        assertEquals("blue is sky the", new Solution151().reverseWords("the sky is blue"));
    }

    @Test
    public void reverseWords_the_sky_is_blue_2() {
        assertEquals("blue is sky the", new Solution151().reverseWords(" the sky  is    blue "));
    }

    @Test
    public void reverseWords_boom() {
        assertEquals("SHAKALAKA BOOM Akbar Allah", new Solution151().reverseWords("  Allah  Akbar BOOM  SHAKALAKA"));
    }
}