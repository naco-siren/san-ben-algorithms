package leetcode.LC_055;

import org.junit.Test;

import static leetcode.LC_055.Solution.canJump;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void canJump_2_3_1_1_4() {
        assertEquals(true, canJump(new int[]{2,3,1,1,4}));
    }

    @Test
    public void canJump_3_2_1_0_4() {
        assertEquals(false, canJump(new int[]{3,2,1,0,4}));
    }

    @Test
    public void canJump_3_3_1_0_4() {
        assertEquals(true, canJump(new int[]{3,3,1,0,4}));
    }
}