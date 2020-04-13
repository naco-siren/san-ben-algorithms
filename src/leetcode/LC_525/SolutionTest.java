package leetcode.LC_525;

import org.junit.Test;

import static leetcode.LC_525.Solution.findMaxLength;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void findMaxLength_0() {
        assertEquals(2, findMaxLength(new int[]{0,1}));
    }

    @Test
    public void findMaxLength_1() {
        assertEquals(2, findMaxLength(new int[]{0,1,0}));
    }

    @Test
    public void findMaxLength_2() {
        assertEquals(6, findMaxLength(new int[]{0,0,1,0,0,0,1,1}));
    }
}