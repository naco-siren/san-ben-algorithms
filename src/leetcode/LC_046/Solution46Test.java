package leetcode.LC_046;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution46Test {

    @Test
    public void permute_1_2_3() {
        List<List<Integer>> results = new Solution46().permute(new int[]{1, 2, 3});
        final int[][] expected = new int[][] {
                {1, 2, 3},
                {1, 3, 2},
                {2, 1, 3},
                {2, 3, 1},
                {3, 1, 2},
                {3, 2, 1},
        };

        assertEquals(expected.length, results.size());

        for (int i = 0; i < expected.length; i++) {
            List<Integer> result = results.get(i);
            assertEquals(expected[i].length, result.size());
            for (int j = 0; j < result.size(); j++)
                assertEquals(new Integer(expected[i][j]), result.get(j));
        }
    }
}