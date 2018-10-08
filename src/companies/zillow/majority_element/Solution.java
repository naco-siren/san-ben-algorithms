package companies.zillow.majority_element;

import java.util.Arrays;

/**
 * Created by naco_siren on 10/3/17.
 */
public class Solution {
    public static void main(String[] args) {
        int r1 = majorityElement(new int[]{1, 2, 3, 2, 1, 2, 2});

        return;
    }

    public static int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count++;
                major = nums[i];
            } else if (major == nums[i]) {
                count++;
            } else
                count--;
        }
        return major;

    }
}
