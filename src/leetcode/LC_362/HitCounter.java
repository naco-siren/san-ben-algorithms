package leetcode.LC_362;

import java.util.HashMap;
import java.util.Map;

/**
 * 362. Design Hit Counter
 *
 * @deprecated In fact, this problem can be solved with a simple list with binary search...
 */
class HitCounter {
    private static final int EXPIRATION = 300;

    // Each hit index represent a second. Value is the number of hits that second
    int[] hits;

    // Each value represents the time of the hit's.
    // Since the hits wrap around, we need to know what value the hit corresponds to
    int[] times;

    /** Initialize your data structure here. */
    public HitCounter() {
        hits = new int[EXPIRATION];
        times = new int[EXPIRATION];
    }

    /**
     * Record a hit.
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        // This takes O(1) times
        int index = timestamp % EXPIRATION;

        /* `times` are only maintaining the last WINDOW (in terms of EXPIRATION size)  */
        if (times[index] != timestamp) {    /* If the hashed index changes, then it means we could... */
            times[index] = timestamp;
            hits[index] = 0;    /* ... abandon the outdated WINDOW (by resetting a new WINDOW) */
        }
        hits[index]++;
    }

    /**
     * Return the number of hits in the past EXPIRATION time.
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        // This takes O(timestamp) time. We need to check every array element to see if it's within timestamp
        int hits = 0;
        for (int i = 0; i < EXPIRATION; i++) {
            if (timestamp - times[i] < 300) {
                hits = hits + this.hits[i];
            }
        }
        return hits;
    }
}

// NAIVE SOLUTION
//
//public class HitCounter2 {
//    private static final int EXPIRATION = 300;
//
//    Map<Integer, Integer> _map;
//
//    /** Initialize your data structure here. */
//    public HitCounter2() {
//        this._map = new HashMap<>();
//    }
//
//    /** Record a hit.
//     @param timestamp - The current timestamp (in seconds granularity). */
//    public void hit(int timestamp) {
//        _map.put(timestamp, _map.getOrDefault(timestamp, 0) + 1);
//    }
//
//    /** Return the number of hits in the past 5 minutes.
//     @param timestamp - The current timestamp (in seconds granularity). */
//    public int getHits(int timestamp) {
//        int hits = 0;
//        for (int i = timestamp - EXPIRATION + 1; i <= timestamp; i++) {
//            hits += _map.getOrDefault(i, 0);
//        }
//        return hits;
//    }
//}
