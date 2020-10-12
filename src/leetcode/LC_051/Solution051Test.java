package leetcode.LC_051;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class Solution051Test {

    @Test
    public void solveNQueens_4() {
        List<List<String>> result = new Solution051().solveNQueens(4);

        Set<List<String>> expected = new HashSet<>();
        expected.add(Arrays.asList(".Q..","...Q","Q...","..Q."));
        expected.add(Arrays.asList("..Q.","Q...","...Q",".Q.."));

        assertEquals(expected, new HashSet<>(result));
    }
}