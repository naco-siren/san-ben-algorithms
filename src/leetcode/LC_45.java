package leetcode;

/**
 * Created by naco_siren on 7/9/17.
 */
public class LC_45 {
    public static void main(String[] args) {
        LC_45 lc = new LC_45();
        int result = lc.jump(new int[]{
                2, 3, 1, 1, 4
        });
    }

    public int jump(int[] nums) {
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
