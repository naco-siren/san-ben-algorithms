package leetcode.LC_043;

import org.junit.Test;

import static leetcode.LC_043.Solution.multiply;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void multiply_0_19() {
        assertEquals("0", multiply("0", "19"));
    }

    @Test
    public void multiply_2_3() {
        assertEquals("6", multiply("2", "3"));
    }

    @Test
    public void multiply_9_9() {
        assertEquals("81", multiply("9", "9"));
    }

    @Test
    public void multiply_2_5() {
        assertEquals("10", multiply("5", "2"));
    }

    @Test
    public void multiply_25_4() {
        assertEquals("100", multiply("25", "4"));
    }

    @Test
    public void multiply_4() {
        assertEquals("98901", multiply("999", "99"));
    }

    @Test
    public void multiply_5() {
        assertEquals("56088", multiply("123", "456"));
    }
}