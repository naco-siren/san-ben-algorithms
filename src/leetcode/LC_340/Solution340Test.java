package leetcode.LC_340;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution340Test {

    @Test
    public void lengthOfLongestSubstringKDistinct_eceba_2() {
        assertEquals(3, new Solution340().lengthOfLongestSubstringKDistinct("eceba", 2));
    }

    @Test
    public void lengthOfLongestSubstringKDistinct_aa_1() {
        assertEquals(2, new Solution340().lengthOfLongestSubstringKDistinct("aa", 1));
    }
}