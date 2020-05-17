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
    List<List<Integer>> permute(int[] num) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        res.add(new ArrayList<>());
        for (int n : num) {
            int size = res.size();
            for (; size > 0; size--) {
                List<Integer> r = res.pollFirst();
                for (int i = 0; i <= r.size(); i++) {
                    List<Integer> t = new ArrayList<>(r);
                    t.add(i, n);
                    res.add(t);
                }
            }
        }
        return res;
    }
}
