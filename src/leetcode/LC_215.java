package leetcode;

import java.util.PriorityQueue;

/**
 * Created by naco_siren on 8/22/17.
 */
public class LC_215 {
    public static void main(String[] args) {
        LC_215 lc = new LC_215();

        int[] input1 = new int[]{3,2,1,5,6,4};
        int r1 = lc.findKthLargest2(input1, 2);

        return;
    }

    public int findKthLargest2(int[] nums, int k) {

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
