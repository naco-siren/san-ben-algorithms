package companies.uber.game_of_go;

import javafx.util.Pair;

import java.util.IllegalFormatException;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        Solution solution1 = new Solution(new char[][] {
                new char[] {'.', '.', '.', '.', '.', '.'},
                new char[] {'.', '.', 'x', '.', '.', '.'},
                new char[] {'.', 'x', 'o', 'x', '.', '.'},
                new char[] {'.', '.', 'x', '.', '.', '.'},
        });
        boolean r1 = solution1.isWhiteDead(2, 2);       // True

        Solution solution2 = new Solution(new char[][] {
                new char[] {'.', '.', '.', '.', '.', '.'},
                new char[] {'.', '.', 'x', '.', '.', '.'},
                new char[] {'.', 'x', 'o', 'x', '.', '.'},
                new char[] {'.', '.', '.', '.', '.', '.'},
        });
        boolean r2 = solution2.isWhiteDead(2, 2);       // False

        Solution solution3 = new Solution(new char[][] {
                new char[] {'.', '.', 'x', '.', '.', '.'},
                new char[] {'.', 'x', 'o', 'x', '.', '.'},
                new char[] {'x', 'x', 'o', 'x', '.', '.'},
                new char[] {'.', '.', 'x', '.', '.', '.'},
        });
        boolean r3 = solution3.isWhiteDead(2, 2);       // True

        Solution solution4 = new Solution(new char[][] {
                new char[] {'.', '.', 'x', '.', '.', '.'},
                new char[] {'.', 'x', 'o', 'x', 'x', 'x'},
                new char[] {'x', 'x', 'o', 'o', 'o', 'o'},
                new char[] {'.', '.', 'x', 'x', 'x', '.'},
        });
        boolean r4 = solution4.isWhiteDead(2, 2);       // False
    }

    Solution(final char[][] map) {
        this.map = map;
        this.R = map.length;
        this.C = map[0].length;
    }

    private char[][] map;
    private int R;
    private int C;

    public boolean isWhiteDead(final int x, final int y) {
        // Initialize DP
        boolean[][] searched = new boolean[R][];
        for (int i = 0; i < R; i++)
            searched[i] = new boolean[C];

        // Perform BFS
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(x, y));

        int r, c;
        while (!queue.isEmpty()) {
            // Poll current point
            Pair<Integer, Integer> cur = queue.poll();
            r = cur.getKey();
            c = cur.getValue();

            // Prune if already searched
            if (searched[r][c])
                continue;

            // Flood (BFS)
            switch (map[r][c]) {
                case '.':
                    return false;
                case 'x':
                    searched[r][c] = true;
                    break;
                case 'o':
                    searched[r][c] = true;
                    if (r >= 1 && !searched[r-1][c]) queue.offer(new Pair<>(r-1, c));
                    if (r+1 < R && !searched[r+1][c]) queue.offer(new Pair<>(r+1, c));
                    if (c >= 1 && !searched[r][c-1]) queue.offer(new Pair<>(r, c-1));
                    if (c+1 < C && !searched[r][c+1]) queue.offer(new Pair<>(r, c+1));
                    break;
                default:
                    throw new IllegalArgumentException("Input map error");
            }
        }
        return true;
    }

}
