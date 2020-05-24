package leetcode.LC_046;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. Permutations
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
class Solution46 {
    /**
     *
     *
     * Approach #1
     *
     *
     */
    List<List<Integer>> permute(int[] num) {
        LinkedList<List<Integer>> results = new LinkedList<>();
        results.add(new ArrayList<>());

        for (int n : num) {
            int size = results.size();

            while (size-- > 0) {
                List<Integer> prefix = results.pollFirst();

                for (int i = 0; i <= prefix.size(); i++) {      // Note the `<=` here
                    List<Integer> clone = new ArrayList<>(prefix);
                    clone.add(i, n);
                    results.add(clone);
                }
            }
        }
        return results;
    }

    /**
     *
     *
     * Approach #2: recursion
     *
     *
     */
    List<List<Integer>> permuteRecur(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        getPermutations(0, nums, res);
        return res;
    }

    private void getPermutations(int i, int[] nums, List<List<Integer>> res) {
        if (i == nums.length - 1) {
            // Add current list to results
            List<Integer> cur = new ArrayList<>();
            for (int num : nums)
                cur.add(num);
            res.add(cur);

        } else {
            // Recursion
            for (int j = i; j < nums.length; j++) {
                swap(i, j, nums);
                getPermutations(i + 1, nums, res);
                swap(i, j, nums);   // Don't forget backtrack~!
            }
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
