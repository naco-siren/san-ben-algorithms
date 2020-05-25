package leetcode.LC_247;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class Solution247Test {
    @Test
    public void findStrobogrammatic_1() {
        List<String> result = new Solution247().findStrobogrammatic(1);

        String[] expected = new String[]{"0", "1", "8"};
        assertEquals(expected.length, result.size());
        assertEquals(new HashSet<>(Arrays.asList(expected)), new HashSet<>(result));
    }

    @Test
    public void findStrobogrammatic_2() {
        List<String> result = new Solution247().findStrobogrammatic(2);

        String[] expected = new String[]{"11","69","88","96"};
        assertEquals(expected.length, result.size());
        assertEquals(new HashSet<>(Arrays.asList(expected)), new HashSet<>(result));
    }

    @Test
    public void findStrobogrammatic_3() {
        List<String> result = new Solution247().findStrobogrammatic(3);

        String[] expected = new String[]{"101","111","181","808","818","888","609","619","689","906","916","986"};
        assertEquals(expected.length, result.size());
        assertEquals(new HashSet<>(Arrays.asList(expected)), new HashSet<>(result));
    }
}