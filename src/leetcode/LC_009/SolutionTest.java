package leetcode.LC_009;

import org.junit.Test;

import static leetcode.LC_009.Solution.isPalindrome;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void isPalindrome_integers() {
        assertTrue(isPalindrome(0));
        assertTrue(isPalindrome(1));
        assertFalse(isPalindrome(-1));
        assertFalse(isPalindrome(12));
        assertTrue(isPalindrome(121));
        assertFalse(isPalindrome(-121));
        assertTrue(isPalindrome(1221));
        assertTrue(isPalindrome(12321));
        assertFalse(isPalindrome(1231));
    }
}
