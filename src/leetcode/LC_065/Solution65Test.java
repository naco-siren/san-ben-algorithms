package leetcode.LC_065;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution65Test {

    @Test
    public void isNumber_0() {
        assertTrue(new Solution65().isNumber("0"));
    }

    @Test
    public void isNumber_minus_plus_3() {
        assertFalse(new Solution65().isNumber("-+3"));
    }

    @Test
    public void isNumber_0_dot_1() {
        assertTrue(new Solution65().isNumber(" 0.1 "));
    }

    @Test
    public void isNumber_dot_1() {
        assertTrue(new Solution65().isNumber(" .1 "));
    }

    @Test
    public void isNumber_1_dot() {
        assertTrue(new Solution65().isNumber("1."));
    }

    @Test
    public void isNumber_abc() {
        assertFalse(new Solution65().isNumber("abc"));
    }

    @Test
    public void isNumber_1_a() {
        assertFalse(new Solution65().isNumber("1 a"));
    }

    @Test
    public void isNumber_2_e_10() {
        assertTrue(new Solution65().isNumber("2e10"));
    }

    @Test
    public void isNumber_4_e_plus() {
        assertFalse(new Solution65().isNumber("4e+"));
    }

    @Test
    public void isNumber_1_dot_e_5() {
        assertTrue(new Solution65().isNumber("1.e5"));
    }

    @Test
    public void isNumber_1_dot_e_5_dot() {
        assertFalse(new Solution65().isNumber("1.e5."));
    }

    @Test
    public void isNumber_minus_90_e_3() {
        assertTrue(new Solution65().isNumber(" -90e3   "));
    }

    @Test
    public void isNumber_1_e() {
        assertFalse(new Solution65().isNumber(" 1e"));
    }

    @Test
    public void isNumber_e_3() {
        assertFalse(new Solution65().isNumber("e3"));
    }

    @Test
    public void isNumber_6_e_minus_3() {
        assertTrue(new Solution65().isNumber(" 6e-1"));
    }

    @Test
    public void isNumber_99_e_2_dot_5() {
        assertFalse(new Solution65().isNumber(" 99e2.5 "));
    }

    @Test
    public void isNumber_53_dot_5_e_93() {
        assertTrue(new Solution65().isNumber("53.5e93"));
    }

    @Test
    public void isNumber_minus_minus_6() {
        assertFalse(new Solution65().isNumber(" --6 "));
    }

    @Test
    public void isNumber_95_a_54_e_53() {
        assertFalse(new Solution65().isNumber("95a54e53"));
    }
}