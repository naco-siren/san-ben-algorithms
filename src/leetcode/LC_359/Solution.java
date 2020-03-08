package leetcode.LC_359;

import java.util.HashMap;

/**
 * 359. Logger rate limiter
 *
 * Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.
 *
 * Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
 *
 * It is possible that several messages arrive roughly at the same time.
 */
public class Solution {
    public static void main(String[] args) {
        Logger logger = new Logger();

        // logging string "foo" at timestamp 1
        logger.shouldPrintMessage(1, "foo"); // returns true;

        // logging string "bar" at timestamp 2
        logger.shouldPrintMessage(2,"bar"); // returns true;

        // logging string "foo" at timestamp 3
        logger.shouldPrintMessage(3,"foo"); // returns false;

        // logging string "bar" at timestamp 8
        logger.shouldPrintMessage(8,"bar"); // returns false;

        // logging string "foo" at timestamp 10
        logger.shouldPrintMessage(10,"foo"); // returns false;

        // logging string "foo" at timestamp 11
        logger.shouldPrintMessage(11,"foo"); // returns true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
class Logger {

    final static int DUPLICATION_THRESHOLD = 10;

    final HashMap<String, Integer> _timestamps;

    /** Initialize your data structure here. */
    public Logger() {
        this._timestamps = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!_timestamps.containsKey(message)) {
            _timestamps.put(message, timestamp);
            return true;
        }

        final int lastTriggerTs = _timestamps.get(message);
        if (timestamp - lastTriggerTs < DUPLICATION_THRESHOLD) {
            return false;
        } else {
            _timestamps.put(message, timestamp);
            return true;
        }
    }
}


