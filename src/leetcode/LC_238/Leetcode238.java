package leetcode.LC_238;

/**
 * 238. Product of Array Except Self
 */
class Leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        final int[] output = new int[nums.length];

        // First pass: from left to right
        output[0] = 1;
        int prod = 1;
        for (int i = 0; i < nums.length - 1; i++) { // WATCH BOUNDARY
            prod *= nums[i];
            output[i + 1] = prod;   // INDEX + 1 to exclude self
        }

        // Second pass: from left to right
        prod = 1;
        for (int i = nums.length - 1; i > 0; i--) { // WATCH BOUNDARY
            prod *= nums[i];
            output[i - 1] *= prod;  // INDEX - 1 to exclude self
        }

        return output;
    }
}
