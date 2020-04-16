package leetcode.LC_055;

/**
 * 55. Jump Game
 */
public class Solution {
    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            // Current index beyond previous reaches
            if (i > maxReach)
                return false;

            // Max reach already touches beyond the end
            if (maxReach >= nums.length - 1)
                return true;

            maxReach = Math.max(i + nums[i], maxReach);
        }
        return true;
    }

    public static boolean canJumpDP(int[] nums) {
        // Validate `nums`
        if (nums == null || nums.length == 0)
            return false;

        // Perform DP
        boolean[] canJumps = new boolean[nums.length];
        canJumps[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (canJumps[i + j]) {
                    canJumps[i] = true;
                    break;
                }
            }
        }
        return canJumps[0];
    }
}
