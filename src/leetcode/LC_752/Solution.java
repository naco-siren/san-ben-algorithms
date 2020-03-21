package leetcode.LC_752;

import java.util.*;

/**
 * 752. Open the Lock
 *
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
 *
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 *
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
 *
 * Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 *
 *
 *
 * The length of deadends will be in the range [1, 500].
 * target will not be in the list deadends.
 * Every string in deadends and the string target will be a string of 4 digits from the 10,000 possibilities '0000' to '9999'.
 *
 */
public class Solution {
    public int openLock(String[] deadends, String target) {
        // Initialize a black list for deadends and attemped moves
        Set<String> muda = new HashSet<>();
        for (String deadend : deadends)
            muda.add(deadend);
        Set<String> attempted = new HashSet<>();

        // Perform a BFS
        final String start = "0000";
        Deque<Integer> depths = new LinkedList<>();
        Deque<String> moves = new LinkedList<>();
        depths.offer(0);
        moves.offer(start);
        attempted.add(start);
        while (!moves.isEmpty()) {
            // Poll current move
            String current = moves.poll();
            int depth = depths.poll();
            if (muda.contains(current))
                continue;

            if (target.equals(current)) {
                return depth;
            }

            for (String next : getNextMoves(current)) {
                if (!attempted.contains(next)) {
                    depths.offer(depth + 1);
                    moves.offer(next);
                    attempted.add(next);
                }
            }
        }

        return -1;
    }

    List<String> getNextMoves(final String current) {
        StringBuilder builder = new StringBuilder(current);
        List<String> nextMoves = new ArrayList<>();     // Change to ll
        for (int i = 0; i < builder.length(); i++) {
            char ch = builder.charAt(i);
            if (ch == '0') {
                builder.setCharAt(i, '9');
                nextMoves.add(builder.toString());
                builder.setCharAt(i, '1');
                nextMoves.add(builder.toString());
                builder.setCharAt(i, ch);
            } else if (ch == '9') {
                builder.setCharAt(i, '8');
                nextMoves.add(builder.toString());
                builder.setCharAt(i, '0');
                nextMoves.add(builder.toString());
                builder.setCharAt(i, ch);
            } else {
                builder.setCharAt(i, (char) (ch - 1));
                nextMoves.add(builder.toString());
                builder.setCharAt(i, (char) (ch + 1));
                nextMoves.add(builder.toString());
                builder.setCharAt(i, ch);
            }
        }
        return nextMoves;
    }
}
