package leetcode.LC_125;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution125Test {

    @Test
    public void isPalindrome_empty() {
        assertTrue(new Solution125().isPalindrome(""));
    }

    @Test
    public void isPalindrome_a() {
        assertTrue(new Solution125().isPalindrome("a"));
    }

    @Test
    public void isPalindrome_xx() {
        assertTrue(new Solution125().isPalindrome("xx"));
    }

    @Test
    public void isPalindrome_xy() {
        assertFalse(new Solution125().isPalindrome("xy"));
    }

    @Test
    public void isPalindrome_race_a_car() {
        assertFalse(new Solution125().isPalindrome("race a car"));
    }

    @Test
    public void isPalindrome_A_man_a_plan_a_canal_Panama() {
        assertTrue(new Solution125().isPalindrome("A man, a plan, a canal: Panama"));
    }
}