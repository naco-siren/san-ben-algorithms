package leetcode.LC_127;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void ladderLength_hit_cog() {

        Solution solution = new Solution();

        int result = solution.ladderLength("hit", "cog",
                Arrays.asList("hot","dot","dog","lot","log","cog"));

        assertEquals(5, result);
    }

}
