package leetcode.LC_249;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class Solution249Test {

    @Test
    public void groupStrings_1() {
        // Expectation
        String[][] expected = new String[][]{
                {"abc", "bcd", "xyz"},
                {"az", "ba"},
                {"acef"},
                {"a", "z"},
        };
        Set<Set<String>> expectedSet = new HashSet<>();
        for (String[] expectedGroup : expected)
            expectedSet.add(new HashSet<>(Arrays.asList(expectedGroup)));


        // Result
        List<List<String>> result = new Solution249().groupStrings(
                new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"});

        Set<Set<String>> resultSet = new HashSet<>();
        for (List<String> group : result)
            resultSet.add(new HashSet<>(group));


        assertEquals(expectedSet, resultSet);
    }

    @Test
    public void findRoot_az() {
        assertEquals("az", new Solution249().findRoot("az"));
    }

    @Test
    public void findRoot_ba() {
        assertEquals("az", new Solution249().findRoot("ba"));
    }

    @Test
    public void offsetBy_a_0() {
        assertEquals('a', new Solution249().offsetBy('a', 0));
    }

    @Test
    public void offsetBy_a_1() {
        assertEquals('b', new Solution249().offsetBy('a', 1));
    }

    @Test
    public void offsetBy_a_25() {
        assertEquals('z', new Solution249().offsetBy('a', 25));
    }

    @Test
    public void offsetBy_a_m1() {
        assertEquals('z', new Solution249().offsetBy('a', -1));
    }
}