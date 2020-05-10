package leetcode.LC_438;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution438Test {

    @Test
    public void findAnagrams_cbaebabacd_abc() {
        List<Integer> result = new Solution438().findAnagrams("cbaebabacd", "abc");
        assertEquals(2, result.size());
        assertEquals(0, (int) result.get(0));
        assertEquals(6, (int) result.get(1));
    }

    @Test
    public void findAnagrams_abab_ab() {
        List<Integer> result = new Solution438().findAnagrams("abab", "ab");
        assertEquals(3, result.size());
        assertEquals(0, (int) result.get(0));
        assertEquals(1, (int) result.get(1));
        assertEquals(2, (int) result.get(2));
    }
}