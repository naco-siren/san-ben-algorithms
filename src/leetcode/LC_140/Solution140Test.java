package leetcode.LC_140;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class Solution140Test {

    @Test
    public void wordBreak_0() {
        List<String> r0 = new Solution140().wordBreak(
                "catsandog",
                Arrays.asList("cats", "dog", "sand", "and", "cat"));

        assertEquals(0, r0.size());
    }

    @Test
    public void wordBreak_1() {
        String[] expectedWords = new String[]{
                "cats and dog",
                "cat sand dog"
        };
        Set<String> expected = new HashSet<>(Arrays.asList(expectedWords));

        List<String> r0 = new Solution140().wordBreak(
                "catsanddog",
                Arrays.asList("cat", "cats", "and", "sand", "dog"));
        assertEquals(expected, new HashSet<>(r0));
    }

    @Test
    public void wordBreak_2() {
        String[] expectedWords = new String[]{
                "pine apple pen apple",
                "pineapple pen apple",
                "pine applepen apple",
        };
        Set<String> expected = new HashSet<>(Arrays.asList(expectedWords));

        List<String> r0 = new Solution140().wordBreak(
                "pineapplepenapple",
                Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"));
        assertEquals(expected, new HashSet<>(r0));
    }

    @Test
    public void wordBreak_3() {
        List<String> r0 = new Solution140().wordBreak(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
        assertTrue(r0.isEmpty());
    }
}