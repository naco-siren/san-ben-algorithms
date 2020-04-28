package leetcode.LC_FirstUniqueNumber;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * First Unique Number
 */
class FirstUnique {
    Deque<Integer> deque;
    Map<Integer, Integer> counts;

    public FirstUnique(int[] nums) {
        this.deque = new LinkedList<>();
        this.counts = new HashMap<>(nums.length);

        for (int num : nums)
            add(num);
    }

    public int showFirstUnique() {
        while (!deque.isEmpty() && counts.get(deque.peekFirst()) > 1) {
            deque.pollFirst();
        }
        return deque.isEmpty() ? -1 : deque.peekFirst();
    }

    public void add(int value) {
        final int count = counts.getOrDefault(value, 0);
        if (count == 0) {
            deque.offerLast(value);
            counts.put(value, 1);
        } else {
            counts.put(value, count + 1);
        }
    }
}
