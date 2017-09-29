package leetcode.LC_215;

import java.util.PriorityQueue;

/**
 * Created by naco_siren on 8/22/17.
 */
public class Solution {
    public static void main(String[] args) {

        int[] input1 = new int[]{3,2,1,5,6,4};
        int r1 = findKthLargest(input1, 1); // [6]!
        int r2 = findKthLargest(input1, 2); // [5]!
        int r3 = findKthLargest(input1, 3); // [4]!
        int r6 = findKthLargest(input1, 6); // [1]!
        int r_2 = findKthLargest2(input1, 2); // [5]!

        return;
    }

    /* Use quick sort's partition to perform binary search */
    public static int findKthLargest(int[] nums, int k) {
        int start = 0, end = nums.length - 1;
        int target = nums.length - k;

        while (start < end) {
            int mid = partition(nums, start, end);

            if (mid == target) {
                break;
            } else if (mid > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nums[target];
    }

    public static int partition(int[] nums, int start, int end) {
        int l = start, r = end;

        while (true) {
            while (l < end && nums[l] <= nums[start]) l++;
            while (r > start && nums[r] >= nums[start]) r--;

            if (l >= r) break;

            swap(nums, l, r);
        }
        swap(nums, start, r);
        return r;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * Use priority queue
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest2(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.offer(val);

            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
