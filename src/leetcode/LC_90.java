package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by naco_siren on 7/24/17.
 */
public class LC_90 {

    public static void main(String[] args) {
        LC_90 lc = new LC_90();
        lc.subsetsWithDup(new int[]{1, 2, 2});

        return;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());

        for (int k = 0; k < nums.length;) {
            int nr = results.size();
            int val = nums[k];
            for (int base = 0; k < nums.length && nums[k] == val; k++, base += nr) {
                for (int j = base; j < base + nr; j++) {
                    ArrayList<Integer> result = (ArrayList<Integer>) results.get(j);
                    ArrayList<Integer> newResult = (ArrayList<Integer>) result.clone();
                    newResult.add(val);
                    results.add(newResult);
                }
            }

        }
        return results;
    }
}
