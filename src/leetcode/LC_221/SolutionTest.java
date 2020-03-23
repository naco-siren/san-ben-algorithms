package leetcode.LC_221;

import org.junit.Test;

import static leetcode.LC_221.Solution.maximalSquare;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void maximalSquare_0() {
        assertEquals(1, maximalSquare(new char[][]{
                {'1'}
        }));
    }

    @Test
    public void maximalSquare_1() {
        assertEquals(4, maximalSquare(new char[][]{
                {'0', '0', '1', '1', '1'},
                {'1', '1', '1', '0', '1'},
                {'1', '0', '1', '1', '1'},
                {'0', '1', '1', '1', '1'},
                {'0', '0', '1', '0', '1'},
        }));
    }

    @Test
    public void maximalSquare_2() {
        assertEquals(9, maximalSquare(new char[][]{
                {'0', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '1', '1', '1'},
                {'0', '1', '1', '1', '1'},
                {'0', '0', '1', '0', '1'},
        }));
    }
}