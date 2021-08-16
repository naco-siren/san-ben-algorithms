package leetcode.LC_1492;

import org.junit.Test;

import static leetcode.LC_1492.Solution1492.kthFactor;
import static org.junit.Assert.*;

public class Solution1492Test {
    @Test
    public void case_normal_smaller() {
        assertEquals(3, kthFactor(15, 2));
    }

    @Test
    public void case_normal_larger() {
        assertEquals(5, kthFactor(15, 3));
    }

    @Test
    public void case_normal_itself() {
        assertEquals(15, kthFactor(15, 4));
    }

    @Test
    public void case_normal_exceed() {
        assertEquals(-1, kthFactor(15, 5));
    }

    @Test
    public void case_large() {
        assertEquals(-1, kthFactor(1000, 30));
    }

    @Test
    public void case_sqrt_dup_edgecase_t() {
        assertEquals(-1, kthFactor(4, 4));
    }

    @Test
    public void case_sqrt_dup_edgecase_f() {
        assertEquals(2, kthFactor(2, 2));
    }
}