package leetcode.LC_946;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class SolutionTest {
    @Test
    public void validateStackSequences_1() {
        Solution solution = new Solution();
        assertEquals(true, solution.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
    }

    @Test
    public void validateStackSequences_2() {
        Solution solution = new Solution();
        assertEquals(true, solution.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,2,1}));
    }

    @Test
    public void validateStackSequences_3() {
        Solution solution = new Solution();
        assertEquals(false, solution.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }
}
