package leetcode.LC_1143;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void longestCommonSubsequence_1() {
        assertEquals(3, new Solution().longestCommonSubsequence("abc", "abc"));
        assertEquals(0, new Solution().longestCommonSubsequence("abcd", "efg"));
        assertEquals(1, new Solution().longestCommonSubsequence("abcde", "efg"));
    }

    @Test
    public void longestCommonSubsequence_2() {
        assertEquals(3, new Solution().longestCommonSubsequence("abcde", "ace"));
        assertEquals(4, new Solution().longestCommonSubsequence("abcde", "acde"));
    }

    @Test
    public void longestCommonSubsequence_3() {
        assertEquals(3, new Solution().longestCommonSubsequence("badce", "acbde"));
    }
}