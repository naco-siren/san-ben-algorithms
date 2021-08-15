package leetcode.LC_1297;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution1297Test {
    @Test
    public void maxFreq_1(){
        final String str = "aababcaab";
        final int maxLetters = 2;
        final int minSize = 3;
        final int maxSize = 4;
        assertEquals(2, new Solution1297().maxFreq(str, maxLetters, minSize, maxSize));
    }

    @Test
    public void maxFreq_2(){
        final String str = "aaaa";
        final int maxLetters = 1;
        final int minSize = 3;
        final int maxSize = 3;
        assertEquals(2, new Solution1297().maxFreq(str, maxLetters, minSize, maxSize));
    }

    @Test
    public void maxFreq_3(){
        final String str = "aabcabcab";
        final int maxLetters = 2;
        final int minSize = 2;
        final int maxSize = 3;
        assertEquals(3, new Solution1297().maxFreq(str, maxLetters, minSize, maxSize));
    }

    @Test
    public void maxFreq_4(){
        final String str = "abcde";
        final int maxLetters = 2;
        final int minSize = 3;
        final int maxSize = 3;
        assertEquals(0, new Solution1297().maxFreq(str, maxLetters, minSize, maxSize));
    }
}