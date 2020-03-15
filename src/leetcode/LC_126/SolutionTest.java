package leetcode.LC_126;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void generatePath() {
        Solution solution = new Solution();
        Solution.Candidate c1 = solution.new Candidate("a", 1, null);
        Solution.Candidate c2 = solution.new Candidate("b", 2, c1);
        Solution.Candidate c3 = solution.new Candidate("c", 3, c2);
        Solution.Candidate c4 = solution.new Candidate("d", 4, c3);

        List<String> path = solution.generatePath(c4);
        assertEquals("a", path.get(0));
        assertEquals("b", path.get(1));
        assertEquals("c", path.get(2));
        assertEquals("d", path.get(3));
    }

    @Test
    public void findLaddersTest() {
        Solution solution = new Solution();

        List<List<String>> paths = solution.findLadders("hit", "cog",
                Arrays.asList("hot","dot","dog","lot","log","cog"));

        assertEquals(2, paths.size());

        List<String> path1 = paths.get(0);
        assertEquals(5, path1.size());
        assertEquals("hit", path1.get(0));
        assertEquals("hot", path1.get(1));
        assertEquals("dot", path1.get(2));
        assertEquals("dog", path1.get(3));
        assertEquals("cog", path1.get(4));

        List<String> path2 = paths.get(1);
        assertEquals(5, path2.size());
        assertEquals("hit", path2.get(0));
        assertEquals("hot", path2.get(1));
        assertEquals("lot", path2.get(2));
        assertEquals("log", path2.get(3));
        assertEquals("cog", path2.get(4));
    }
}
