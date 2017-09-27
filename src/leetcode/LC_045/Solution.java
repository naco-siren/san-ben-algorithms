package leetcode.LC_045;

/**
 * Created by naco_siren on 7/9/17.
 */
public class Solution {
    public static void main(String[] args) {

        int r1 = jump(new int[]{2, 3, 1, 1, 4});

        return;
    }

    public static int jump(int[] nums) {
        if (nums == null)
            return 0;
        int len = nums.length;

        int first = 0, last = 0, jump = 0, maxd = 0;
        while (maxd < len - 1 && first < last) {
            for (int n = first; n <= last; n++) {
                int newd = n + nums[n];
                if (newd > maxd)
                    maxd = newd;
            }
            first = last + 1;
            last = maxd;
            jump++;
        }
        return maxd >= len - 1 ? jump : -1;
    }
}
