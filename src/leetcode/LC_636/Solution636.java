package leetcode.LC_636;

import java.util.List;
import java.util.Stack;

/**
 * 636. Exclusive Time of Functions
 */
public class Solution636 {
    private static final String LOG_SEPARATOR = ":";
    private static final String LOG_START = "start";

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];

        Stack<Log> stack = new Stack<>();
        for (String log : logs) {
            final Log newLog = parseLog(log);

            if (newLog.start) {
                // Update top stack frame's exclusive time, if any
                if (!stack.isEmpty()) {
                    Log top = stack.peek();
                    res[top.id] += (newLog.time - top.time);
                }

                // Push in new stack frame
                stack.push(newLog);

            } else {
                // Pop out top stack frame and update its exclusive time
                Log top = stack.pop();
                res[top.id] += (newLog.time - top.time + 1);

                // Update current stack frame's time
                if (!stack.isEmpty()) {
                    Log current = stack.peek();
                    current.time = newLog.time + 1;
                }
            }
        }
        return res;
    }

    private Log parseLog(String log) {
        String[] parts = log.split(LOG_SEPARATOR);
        return new Log(
                Integer.parseInt(parts[0]),
                LOG_START.equals(parts[1]),
                Integer.parseInt(parts[2])
        );
    }

    static class Log {
        final int id;
        final boolean start;
        int time;
        Log(int id, boolean start, int time) {
            this.id = id;
            this.start = start;
            this.time = time;
        }
    }
}
