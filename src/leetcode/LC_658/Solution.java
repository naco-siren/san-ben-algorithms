package leetcode.LC_658;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        List<Integer> r0 = s1.solve(new int[]{1,2,3,4,5}, 4, -1);    // [1,2,3,4]
        List<Integer> rN = s1.solve(new int[]{1,2,3,4,5}, 3, 6);    // [3,4,5]

        List<Integer> r1 = s1.solve(new int[]{1,2,3,4,5}, 4, 3);    // [1,2,3,4]
        List<Integer> r2 = s1.solve(new int[]{1,2,3,4,5}, 3, 3);    // [2,3,4]

        List<Integer> r3 = s1.solve(new int[]{1,3,4,5}, 3, 2);    // [1,3,4]
        List<Integer> r4 = s1.solve(new int[]{1,2,3,5}, 3, 4);    // [2,3,5]
        List<Integer> r5 = s1.solve(new int[]{1,3,4,5}, 2, 2);    // [1,3]

        List<Integer> rDup = s1.solve(new int[]{0,0,1,2,3,3,4,7,7,8}, 3, 5);    // [3, 3, 4]
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //-------- Main idea behind the binary search algorithm ----------//
        // 1) result will be a consecutive subarray of k size
        // 2) say if we need to pick 4 elements, now we are looking at 5 elements: n1, n2, n3, n4, n5
        //    we need to compare two ends: diff(x, n1) and diff(x, n5),
        //    the number with bigger diff on the end will be eliminated
        //----------------------------------------------------------------//
        // lo and hi: range of all possible start of subarray with size k + 1, so we could compare both ends
        int lo = 0, hi = arr.length - k - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // for subarray starting at mid with size k+1, we compare element of two ends to eliminate the loser
            if (Math.abs(x - arr[mid]) > Math.abs(x - arr[mid+k])) {
                lo = mid + 1; // arr[mid] is the one further away from x, eliminate range[lo, mid]
            } else {
                hi = mid - 1; // arr[mid+k] is the one further away, all [mid, hi] will have simiar situation, elimiate them
            }
        }
        // Generate subarray
        List<Integer> res = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            res.add(arr[lo + i]);
        }
        return res;
    }


    List<Integer> solve(final int[] arr, int k, final int x) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int abs1 = Math.abs(o1 - x);
                int abs2 = Math.abs(o2 - x);
                return abs1 == abs2 ? o1 - o2 : abs1 - abs2;
            }
        });
        for (int ele : arr)
            priorityQueue.offer(ele);

        LinkedList<Integer> result = new LinkedList<>();
        while (k > 0) {
            result.add(priorityQueue.poll());
            k--;
        }
        Collections.sort(result);
        return result;
    }
}
