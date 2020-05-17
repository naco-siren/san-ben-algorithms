package leetcode.LC_039;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * 39. Combination Sum
 */
class Solution39 {
    List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Require candidates array to be ascending
        Arrays.sort(candidates);

        // Perform a DFS
        List<List<Integer>> results = new ArrayList<>();
        search(candidates, target, 0, new ArrayList<>(), results);
        return results;
    }

    private void search(int[] candidates, final int target, final int index, List<Integer> prefix, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(prefix));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            final int cand = candidates[i];
            if (cand > target)
                continue;

            prefix.add(cand);
            search(candidates, target - cand, i, prefix, results);
            prefix.remove(prefix.size() - 1);
        }
    }


    List<List<Integer>> combinationSumTreeMap(int[] candidates, int target) {
        // Maintain a TreeMap for candidates
        TreeSet<Integer> cands = new TreeSet<>();
        for (int cand : candidates)
            cands.add(cand);

        // Preform a DFS
        List<List<Integer>> results = new ArrayList<>();
        searchTreeMap(cands, target, new ArrayList<>(), results);
        return results;
    }

    private void searchTreeMap(TreeSet<Integer> cands, final int target, List<Integer> prefix, List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<>(prefix));
            return;
        }
        for (Integer cand : cands.headSet(target, true)) {
            if (!prefix.isEmpty() && cand < prefix.get(prefix.size() - 1))
                continue;

            prefix.add(cand);
            searchTreeMap(cands, target - cand, prefix, results);
            prefix.remove(prefix.size() - 1);
        }
    }
}
