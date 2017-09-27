package leetcode.LC_047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by naco_siren on 9/5/17.
 */
public class Solution {
    public static void main(String[] args) {

//        permuteUnique(new int[]{1, 3, 2, 4});
        permuteUnique(new int[]{1, 3, 1, 2});

        return;
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        ArrayList<Integer> perm = new ArrayList<Integer>();
        for (int num : nums)
            perm.add(num);

        ArrayList<List<Integer>> perms = new ArrayList<>();
        do {
            perms.add(new ArrayList<>(perm));
        } while (hasNext(perm));

        return perms;
    }

    private static boolean hasNext(ArrayList<Integer> perm) {
        int n, m;

        /* n: L <- R, first [n] < [n+1] */
        for (n = perm.size() - 2; n >= 0 && perm.get(n) >= perm.get(n+1); n--);
        if (n < 0) return false;

        /* m: n -> R, first [m] <= [n] */
        for (m = n + 1; m < perm.size() && perm.get(m) > perm.get(n); m++);
        m--;

        /* Swap [n] <> [m] */
        int temp = perm.get(n);
        perm.set(n, perm.get(m));
        perm.set(m, temp);

        /* Reverse [n+1] ~ [R] */
        for (int l = n+1, r = perm.size() - 1; l < r; l++, r--) {
            int temp2 = perm.get(l);
            perm.set(l, perm.get(r));
            perm.set(r, temp2);
        }
        return true;
    }
}
