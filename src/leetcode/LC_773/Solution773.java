package leetcode.LC_773;

import java.util.*;

/**
 * 773. Sliding Puzzle
 */
class Solution773 {
    public int slidingPuzzle(int[][] board) {
        int R = board.length, C = board[0].length;

        // Locate initial `zero` coordinates
        int sr = 0, sc = 0;
        search:
        for (sr = 0; sr < R; sr++)
            for (sc = 0; sc < C; sc++)
                if (board[sr][sc] == 0)
                    break search;

        // Memorize search states with a queue
        Queue<State> queue = new ArrayDeque<>();
        State start = new State(board, sr, sc, 0);
        queue.offer(start);

        // Memorize searched states with a set
        Set<String> seen = new HashSet<>();
        seen.add(start.boardstring);

        // Constants
        final String TARGET = Arrays.deepToString(new int[][]{{1, 2, 3}, {4, 5, 0}});
        final int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Perform BFS
        while (!queue.isEmpty()) {
            // Return on target found
            final State state = queue.poll();
            if (state.boardstring.equals(TARGET))
                return state.depth;

            // Search four directions as candidates
            for (int[] direction : DIRECTIONS) {
                int nextZeroR = direction[0] + state.zero_r;
                int nextZeroC = direction[1] + state.zero_c;

                // Prune invalid candidate
                if ((Math.abs(nextZeroR - state.zero_r) + Math.abs(nextZeroC - state.zero_c) != 1) ||
                        nextZeroR < 0 || nextZeroR >= R || nextZeroC < 0 || nextZeroC >= C)
                    continue;

                // Clone board
                int[][] newboard = new int[R][C];
                int t = 0;
                for (int[] row : state.board)
                    newboard[t++] = row.clone();

                // Swap
                newboard[state.zero_r][state.zero_c] = newboard[nextZeroR][nextZeroC];
                newboard[nextZeroR][nextZeroC] = 0;

                // Avoid searching visited states
                final State candidate = new State(newboard, nextZeroR, nextZeroC, state.depth + 1);
                if (seen.contains(candidate.boardstring))
                    continue;

                // Update queue and set
                queue.add(candidate);
                seen.add(candidate.boardstring);
            }
        }

        return -1;
    }

    private static class State {
        int[][] board;
        String boardstring;

        int zero_r;
        int zero_c;

        int depth;

        State(int[][] B, int r, int c, int d) {
            board = B;
            boardstring = Arrays.deepToString(board);

            zero_r = r;
            zero_c = c;

            depth = d;
        }
    }
}