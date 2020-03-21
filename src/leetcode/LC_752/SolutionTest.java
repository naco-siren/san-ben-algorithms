package leetcode.LC_752;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class SolutionTest {
    @Test
    public void getNextMoves_1() {
        Set<String> expectation = new HashSet<>();
        expectation.add("0001");
        expectation.add("0010");
        expectation.add("0100");
        expectation.add("1000");
        expectation.add("0009");
        expectation.add("0090");
        expectation.add("0900");
        expectation.add("9000");

        Set<String> realization = new HashSet<>(new Solution().getNextMoves("0000"));
        assertEquals(8, realization.size());
        assertThat(realization, is(expectation));
    }

    @Test
    public void getNextMoves_2() {
        Set<String> expectation = new HashSet<>();
        expectation.add("9990");
        expectation.add("9909");
        expectation.add("9099");
        expectation.add("0999");
        expectation.add("9998");
        expectation.add("9989");
        expectation.add("9899");
        expectation.add("8999");

        Set<String> realization = new HashSet<>(new Solution().getNextMoves("9999"));
        assertEquals(8, realization.size());
        assertThat(realization, is(expectation));
    }

    @Test
    public void openLock_1() {
        assertEquals(1, new Solution().openLock(
                new String[]{"8888"},
                "0009")
        );
    }

    @Test
    public void openLock_2() {
        assertEquals(-1, new Solution().openLock(
                new String[]{"0000"},
                "8888")
        );
    }

    @Test
    public void openLock_3() {
        assertEquals(-1, new Solution().openLock(
                new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"},
                "8888")
        );
    }

    @Test
    public void openLock_4() {
        assertEquals(6, new Solution().openLock(
                new String[]{"0201","0101","0102","1212","2002"},
                "0202")
        );
    }
}