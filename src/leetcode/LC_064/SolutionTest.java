package leetcode.LC_064;

import org.junit.Test;

import static leetcode.LC_064.Solution.minPathSum;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void minPathSum_0() {
        assertEquals(7, minPathSum(new int[][]{
            new int[]{1,3,1},
            new int[]{1,5,1},
            new int[]{4,2,1},
        }));
    }
}