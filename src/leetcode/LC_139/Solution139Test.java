package leetcode.LC_139;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Solution139Test {

    @Test
    public void wordBreak_leetcode() {
        List<String> words = new ArrayList<>(Arrays.asList("leet", "code"));
        assertTrue(new Solution139().wordBreak("leetcode", words));
    }

    @Test
    public void wordBreak_applepenapple() {
        List<String> words = new ArrayList<>(Arrays.asList("apple", "pen"));
        assertTrue(new Solution139().wordBreak("applepenapple", words));
    }

    @Test
    public void wordBreak_catsandog() {
        List<String> words = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        assertFalse(new Solution139().wordBreak("catsandog", words));
    }
}