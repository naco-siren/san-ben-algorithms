package leetcode.LC_078;

import java.util.*;

/**
 * 78. Subsets
 */
class Solution78 {
    List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());

        for (int num : nums) {
            int size = results.size();
            for (int i = 0; i < size; i++) {
                List<Integer> clone = new ArrayList<>(results.get(i));
                clone.add(num);
                results.add(clone);
            }
        }
        return results;
    }
}
