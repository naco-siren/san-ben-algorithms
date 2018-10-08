package companies.google.matrix_paths;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s1 = new Solution(new int[][]{
            new int[]{1, 0, 1, 1, 0},
            new int[]{1, 1, 1, 0, 1},
            new int[]{1, 1, 0, 1, 1},
            new int[]{0, 1, 1, 0, 1},
        });
        List<List<int[]>> r1 = s1.solve(3, 2);

        return;
    }

    /**
     * Constructor
     * @param matrix 2-D matrix indicating the map
     */
    public Solution(int[][] matrix) {
        this._matrix = matrix;
        this.R = matrix.length;
        this.C = matrix[0].length;
    }
    private int[][] _matrix;
    private int R;
    private int C;

    /**
     * Entrance of the search solution
     * @param start is index of first row's start col
     * @param end is index of last row's end col
     * @return a list of paths
     */
    public List<List<int[]>> solve(int start, int end) {
        // Initialize member variables
        _end = end;
        _result = new LinkedList<>();

        // Prefix for recursion
        ArrayList<int[]> prefix = new ArrayList<>();
        recur(prefix, 0, start);

        return _result;
    }
    private int _end;
    private List<List<int[]>> _result;

    /**
     * Recursion for path searching
     * @param prefix the trace so far
     * @param r is index of current row
     * @param c is index of current col
     */
    private void recur(ArrayList<int[]> prefix, int r, int c){
        // Stop if not available
        if (_matrix[r][c] == 0) return;

        // Add current coordination into prefix
        ArrayList<int[]> newPrefix = new ArrayList<>(prefix);
        newPrefix.add(new int[]{r, c});

        // Search
        if (r < R - 1) {
            // Search downwards
            if (_matrix[r+1][c] == 1) {
                recur(new ArrayList<>(newPrefix), r+1, c);
            }

            // Search leftwards
            ArrayList<int[]> newPrefixL = new ArrayList<>(newPrefix);
            for (int j = c; j > 0 && _matrix[r][j-1] == 1; j--) {
                newPrefixL.add(new int[]{r, j-1});
                if (_matrix[r+1][j-1] == 1)
                    recur(new ArrayList<>(newPrefixL), r+1, j-1);
            }

            // Search rightwards
            ArrayList<int[]> newPrefixR = new ArrayList<>(newPrefix);
            for (int j = c; j < C-1 && _matrix[r][j+1] == 1; j++) {
                newPrefixR.add(new int[]{r, j+1});
                if (_matrix[r+1][j+1] == 1)
                    recur(new ArrayList<>(newPrefixR), r+1, j+1);
            }

        } else {
            if (c == _end) {
                _result.add(newPrefix);
            } else if (c < _end && _matrix[r][c+1] == 1) {
                recur(new ArrayList<>(newPrefix), r, c+1);
            } else if (c > _end && _matrix[r][c-1] == 1) {
                recur(new ArrayList<>(newPrefix), r, c-1);
            }
        }
    }
}
