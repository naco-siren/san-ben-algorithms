package leetcode;

import java.util.TreeSet;

/**
 * Created by naco_siren on 9/18/17.
 */
public class LC_220 {
    public static void main(String[] args) {

        boolean r1 = containsNearbyAlmostDuplicate(new int[]{-2147483648,-2147483647}, 3,3);

        return;
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || t < 0 || k <= 0) return false;

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            int right = num + t;
            if (right < num) right = Integer.MAX_VALUE;
            Integer floor = set.floor(right);
            if (floor != null && floor >= num) return true;

            int left = num - t;
            if (left > num) left = Integer.MIN_VALUE;
            Integer ceiling = set.ceiling(left);
            if (ceiling != null && ceiling <= num) return true;

            set.add(num);
            if (i >= k)
                set.remove(nums[i-k]);
        }

        return false;
    }
}
