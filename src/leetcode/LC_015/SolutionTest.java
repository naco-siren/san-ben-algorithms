package leetcode.LC_015;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void threeSum_1() {
        List<List<Integer>> result = new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4});

        assertEquals(2, result.size());
    }
}