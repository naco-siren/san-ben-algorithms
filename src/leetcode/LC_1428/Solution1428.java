package leetcode.LC_1428;

import java.util.List;

/**
 * 1428. Leftmost Column with at Least a One
 */
public class Solution1428 {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimens = binaryMatrix.dimensions();
        final int R = dimens.get(0), C = dimens.get(1);

        int answer = -1;
        int r = 0, c = C - 1;
        while (r < R && c >= 0) {
            if (binaryMatrix.get(r, c) == 1) {
                answer = c;
                c--;    // If (r,c) == 1, then we could probe its left cell.
            } else {
                r++;    // This whole row is useless, move on to next row.
            }
        }
        return answer;
    }

    public int leftMostColumnWithOne2(BinaryMatrix binaryMatrix) {
        List<Integer> dimens = binaryMatrix.dimensions();
        final int R = dimens.get(0), C = dimens.get(1);

        int answer = -1;
        int r = R - 1, c = C - 1;
        while (r >= 0 && c >= 0) {
            if (binaryMatrix.get(r, c) == 1) {
                answer = c;
                c--;
            } else {
                r--;
            }
        }
        return answer;
    }
}

interface BinaryMatrix {
    public int get(int x, int y);
    public List<Integer> dimensions();
};
