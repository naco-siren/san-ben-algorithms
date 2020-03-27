package leetcode.LC_729;

import java.util.TreeMap;

/**
 * 729. My Calendar I
 */
class MyCalendar {
    TreeMap<Integer, Integer> treeMap;

    public MyCalendar() {
        this.treeMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        final Integer prev = treeMap.floorKey(start);
        final Integer next = treeMap.ceilingKey(start);
        if ((prev == null || treeMap.get(prev) <= start)
                &&  (next == null || end <= next)) {
            treeMap.put(start, end);
            return true;
        }
        return false;
    }
}