package leetcode.LC_215;

import java.util.PriorityQueue;

/**
 * Created by naco_siren on 8/22/17.
 */
public class Solution {
    public static void main(String[] args) {

        int[] input1 = new int[]{3,2,1,5,6,4};
        int r1 = findKthLargest(input1, 2);

        return;
    }

    /**
     * Use priority queue
     *
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {

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
