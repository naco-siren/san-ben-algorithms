package leetcode.LC_078;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class Solution78Test {

    @Test
    public void subsets_1_2_3() {
        List<List<Integer>> results = new Solution78().subsets(new int[]{1, 2, 3});

        Integer[][] expected = new Integer[][]{
                {},
                {1},
                {2},
                {3},
                {1, 2},
                {2, 3},
                {1, 3},
                {1, 2, 3},
        };
        HashSet<List<Integer>> expectedSet = new HashSet<>();
        for (Integer[] exp : expected)
             expectedSet.add(Arrays.asList(exp));

        assertEquals(expected.length, results.size());
        assertEquals(expectedSet, new HashSet<>(results));
    }
}