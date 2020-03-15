package leetcode.LC_212;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void findWords_0() {
        Solution solution = new Solution();
        final String[] dict = new String[]{"aaa"};

        List<String> r = solution.findWords(new char[][]{
                new char[] {'a', 'a'},
        }, dict);

        assertEquals(0, r.size());
    }
    @Test
    public void findWords_1() {
        Solution solution = new Solution();
        final String[] dict = new String[]{"aeim", "bfj", "cg", "d", "mnop"};

        List<String> r = solution.findWords(new char[][]{
                new char[] {'a', 'b', 'c', 'd'},
                new char[] {'e', 'f', 'g', 'h'},
                new char[] {'i', 'j', 'k', 'l'},
                new char[] {'m', 'n', 'o', 'p'},
        }, dict);

        assertEquals(new HashSet<>(Arrays.asList(dict)), new HashSet<>(r));
    }

    @Test
    public void findWords_2() {
        Solution solution = new Solution();
        final String[] dict = new String[]{"nokl", "nokj", "okjnmi"};

        List<String> r = solution.findWords(new char[][]{
                new char[] {'a', 'b', 'c', 'd'},
                new char[] {'e', 'f', 'g', 'h'},
                new char[] {'i', 'j', 'k', 'l'},
                new char[] {'m', 'n', 'o', 'p'},
        }, dict);

        assertEquals(new HashSet<>(Arrays.asList(dict)), new HashSet<>(r));
    }

    @Test
    public void findWords_3() {
        Solution solution = new Solution();
        final String[] dict = new String[]{"plhdcbaeim", "plhdcbaeimnjfgko"};

        List<String> r = solution.findWords(new char[][]{
                new char[] {'a', 'b', 'c', 'd'},
                new char[] {'e', 'f', 'g', 'h'},
                new char[] {'i', 'j', 'k', 'l'},
                new char[] {'m', 'n', 'o', 'p'},
        }, dict);

        assertEquals(new HashSet<>(Arrays.asList(dict)), new HashSet<>(r));
    }

    @Test
    public void constructTrie_trieContains() {
        Solution solution = new Solution();
        Solution.TrieNode root = solution.constructTrie(new String[]{
                "a", "as", "ashford", "j", "jojo", "joseph", "jonathan"
        });

        assertTrue(solution.trieContains(root, "a"));
        assertTrue(solution.trieContains(root, "as"));
        assertFalse(solution.trieContains(root, "ass"));
        assertTrue(solution.trieContains(root, "ashford"));
        assertFalse(solution.trieContains(root, "ashfor"));

        assertTrue(solution.trieContains(root, "j"));
        assertFalse(solution.trieContains(root, "jo"));
        assertFalse(solution.trieContains(root, "joj"));
        assertTrue(solution.trieContains(root, "jojo"));
        assertTrue(solution.trieContains(root, "joseph"));
        assertTrue(solution.trieContains(root, "jonathan"));
    }
}
