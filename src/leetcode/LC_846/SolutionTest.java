package leetcode.LC_846;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void isNStraightHand_1() {
        Solution solution = new Solution();
        assertEquals(true, solution.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 3));
    }

    @Test
    public void isNStraightHand_2() {
        Solution solution = new Solution();
        assertEquals(false, solution.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8}, 4));
    }

    @Test
    public void isNStraightHand_3() {
        Solution solution = new Solution();
        assertEquals(false, solution.isNStraightHand(new int[]{1,2,3,6,2,3,3,7,8}, 3));
    }

    @Test
    public void isNStraightHand_4() {
        Solution solution = new Solution();
        assertEquals(false, solution.isNStraightHand(new int[]{1,2,3,4,5}, 4));
    }

    @Test
    public void isNStraightHand_5() {
        Solution solution = new Solution();
        assertEquals(false, solution.isNStraightHand(new int[]{5, 1}, 2));
    }

    @Test
    public void isNStraightHand_6() {
        Solution solution = new Solution();
        assertEquals(true, solution.isNStraightHand(new int[]{5, 1}, 1));
    }
}
