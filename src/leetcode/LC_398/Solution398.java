package leetcode.LC_398;

import java.util.*;

/**
 * 398. Random Pick Index
 */
public class Solution398 {

    /* Solution 1. */
    int[] numbers;
    Random rand;

    public Solution398(int[] nums) {
        numbers = nums;
        rand = new Random();
    }

    public int pick2(int target) {
        int count = 0;
        int idx = -1;
        for (int i=0;i<numbers.length;i++) {
            if (numbers[i] == target) {
                count++;
                if (rand.nextInt(count) == 0)
                    idx = i;
            }
        }
        return idx;
    }


//    /* Solution 2. Higher memory cost */
//    Random _random;
//    Map<Integer, List<Integer>> _map;
//
//    public Solution398(int[] nums) {
//        _random = new Random();
//        _map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++)
//            _map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
//    }
//
//    public int pick(int target) {
//        List<Integer> indices = _map.get(target);
//        return indices.get(_random.nextInt(indices.size()));
//    }
}
