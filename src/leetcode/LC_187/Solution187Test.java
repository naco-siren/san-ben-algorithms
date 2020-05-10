package leetcode.LC_187;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class Solution187Test {

    @Test
    public void shiftTenDigitDnaSeqEncoding() {
        Solution187 solution = new Solution187();
        int first = solution.encodeTenDigitDnaSeq("ATCGATCGAT");
        int second = solution.encodeTenDigitDnaSeq("TCGATCGATA");
        int calculated = solution.shiftTenDigitDnaSeqEncoding(first, 'A');
        assertEquals(second, calculated);
    }

    @Test
    public void findRepeatedDnaSequences_AAAAAAAAAAA() {
        List<String> list = new Solution187().findRepeatedDnaSequences("AAAAAAAAAAA");
        HashSet<String> set = new HashSet<>(list);
        assertEquals(list.size(), set.size());

        HashSet<String> expected = new HashSet<>();
        expected.add("AAAAAAAAAA");

        assertEquals(expected, set);
    }

    @Test
    public void findRepeatedDnaSequences_AAAAAAAAAAAA() {
        List<String> list = new Solution187().findRepeatedDnaSequences("AAAAAAAAAAA");
        HashSet<String> set = new HashSet<>(list);
        assertEquals(list.size(), set.size());

        HashSet<String> expected = new HashSet<>();
        expected.add("AAAAAAAAAA");

        assertEquals(expected, set);
    }

    @Test
    public void findRepeatedDnaSequences_AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT() {
        List<String> list = new Solution187().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        HashSet<String> set = new HashSet<>(list);
        assertEquals(list.size(), set.size());

        HashSet<String> expected = new HashSet<>();
        expected.add("AAAAACCCCC");
        expected.add("CCCCCAAAAA");

        assertEquals(expected, set);
    }
}