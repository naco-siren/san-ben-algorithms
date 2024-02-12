package leetcode.LC_3030;

import base.Pair;

import java.util.*;

/**
 * 3030. Find the Grid of Region Average
 */
public class Solution3030 {
    public int[][] resultGrid(int[][] image, int threshold) {
        final int R = image.length, C = image[0].length;

        // `downs`: whether (r, c) and (r + 1, c) within threshold
        boolean[][] downs = new boolean[R-1][];
        for (int i = 0; i < R - 1; i++)
            downs[i] = new boolean[C];

        // `rights`: ditto for (r, c) and (r, c + 1)
        boolean[][] rights = new boolean[R][];
        for (int i = 0; i < R; i++)
            rights[i] = new boolean[C - 1];

        // fill in `downs` and `rights`
        for (int r = 0; r < R - 1; r++)
            for (int c = 0; c < C; c++)
                if (Math.abs(image[r][c] - image[r+1][c]) <= threshold) {
                    downs[r][c] = true;
                }
        for (int r = 0; r < R; r++)
            for (int c = 0; c < C - 1; c++)
                if (Math.abs(image[r][c] - image[r][c+1]) <= threshold) {
                    rights[r][c] = true;
                }

        // Scan the image against `downs` and `rights`. `r` and `c` is the top left pixel's coords
        Queue<Pair<Integer, Integer>> regionOrigins = new LinkedList<>();
        for (int r = 0; r < R - 2; r++) {
            int c = 0;
            while (c < C - 2) {
                if (!downs[r][c] || !downs[r+1][c] || !rights[r][c] || !rights[r+1][c] || !rights[r+2][c]) {
                    c++;
                    continue;
                } else if (!downs[r][c+1] || !downs[r+1][c+1] || !rights[r][c+1] || !rights[r+1][c+1] || !rights[r+2][c+1]) {
                    c+=2;
                    continue;
                } else if (!downs[r][c+2] || !downs[r+1][c+2]) {
                    c+=3;
                    continue;
                } else {
                    regionOrigins.offer(new Pair(r, c));
                    c++;
                }
            }
        }

        // `hits`: times of a pixel falls into a `region`
        int[][] hits = new int[R][];
        for (int r = 0; r < R; r++)
            hits[r] = new int[C];

        int[][] result = new int[R][];
        for (int r = 0; r < R; r++)
            result[r] = new int[C];

        while (!regionOrigins.isEmpty()) {
            Pair<Integer, Integer> origin = regionOrigins.poll();
            final int r = origin.getKey(), c = origin.getValue();

            // Calculate the avg intensity
            int intensity = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    intensity += image[r + i][c + j];
                }
            }
            intensity /= 9;

            // Assign value to the `hits` and `result`
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++) {
                    hits[r+i][c+j] += 1;
                    result[r+i][c+j] += intensity;
                }
        }

        // Finalize the `result` based on `hits`
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                final int hit = hits[r][c];
                if (hit == 0) {
                    result[r][c] = image[r][c];
                } else {
                    result[r][c] /= hit;
                }
            }
        }
        return result;
    }
}
