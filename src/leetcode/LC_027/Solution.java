package leetcode.LC_027;

public class Solution {
    public static void main(String[] args) {
        int[] i1 = new int[]{3, 2, 2, 3};
        int r1 = removeElement(i1, 3); // 2: [2, 2]

        int[] i2 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int r2 = removeElement(i2, 2); // 5: [0, 1, 3, 0, 4]
    }

    public static int removeElement(int[] nums, final int val) {
        int w = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] != val) {
                nums[w] = nums[r];
                w++;
            }
        }
        return w;
    }

//    public static int removeElement2(int[] nums, final int val) {
//        int len = nums.length;
//        int r = 0, w = 0;
//
//        while (r < len) {
//            while (r < len && nums[r] == val)
//                r++;
//
//            if (r < len)
//                nums[w++] = nums[r++];
//        }
//
//        return w;
//    }
}
