package leetcode.LC_039;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 39. Combination Sum
 */
class Solution39 {
    List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Maintain a TreeMap for candidates
        TreeSet<Integer> cands = new TreeSet<>();
        for (int cand : candidates)
            cands.add(cand);

        // Preform a DFS
        List<List<Integer>> results = new ArrayList<>();
        search(cands, target, new ArrayList<>(), results);
        return results;
    }

    private void search(TreeSet<Integer> cands, final int target, List<Integer> prefix, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(prefix));
            return;
        }
        for (Integer cand : cands.headSet(target, true)) {
            if (!prefix.isEmpty() && cand < prefix.get(prefix.size() - 1))
                continue;

            prefix.add(cand);
            search(cands, target - cand, prefix, results);
            prefix.remove(prefix.size() - 1);
        }
    }
}
