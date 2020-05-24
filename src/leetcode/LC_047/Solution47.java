package leetcode.LC_047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. Permutations II
 */
public class Solution47 {

    /**
     *
     *
     * Iterator approach
     *
     */
    List<List<Integer>> permuteUnique(int[] nums) {
        // Initial permutation which contains original numbers in sorted (ascending) order
        ArrayList<Integer> perm = new ArrayList<>();
        Arrays.sort(nums);
        for (int num : nums)
            perm.add(num);

        // Iterate through all permutations and add them into results
        ArrayList<List<Integer>> perms = new ArrayList<>();
        do {
            perms.add(new ArrayList<>(perm));
        } while (hasNext(perm));    // Iterator pattern
        return perms;
    }

    /**
     * Find the next number that is the ceiling of current number:
     * 1. first locate the digit just before the descending suffix, mark as `n`.
     * 2. then locate the minimum digit in this descending suffix, which is larger than `n`, mark as `m`.
     * 3. swap `n` and `m`, then reverse the whole (still descending) suffix, so that this suffix becomes the min value.
     *
     * If you are having trouble understanding this algorithm, refer to "31. Next Permutation" first!
     *
     * @see leetcode.LC_031.Solution31
     */
    private boolean hasNext(ArrayList<Integer> perm) {
        int n, m;

        // n: [L <- R], first [n] < [n+1]
        for (n = perm.size() - 2; n >= 0 && perm.get(n) >= perm.get(n+1); n--);
        if (n < 0)
            return false;

        // m: [n -> R], last [m] > [n]
        for (m = n + 1; m < perm.size() && perm.get(m) > perm.get(n); m++);
        m--;

        // Swap [n] <> [m]
        int temp = perm.get(n);
        perm.set(n, perm.get(m));
        perm.set(m, temp);

        // Reverse [n+1] ~ [R]
        for (int l = n+1, r = perm.size() - 1; l < r; l++, r--) {
            int temp2 = perm.get(l);
            perm.set(l, perm.get(r));
            perm.set(r, temp2);
        }
        return true;
    }
}
