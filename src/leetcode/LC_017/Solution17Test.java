package leetcode.LC_017;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class Solution17Test {

    @Test
    public void letterCombinations_() {
        List<String> result = new Solution17().letterCombinations("");
        assertEquals(0, result.size());
    }

    @Test
    public void letterCombinations_23() {
        List<String> result = new Solution17().letterCombinations("23");
        List<String> expected = Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");

        assertEquals(new HashSet<>(expected), new HashSet<>(result));
    }
}