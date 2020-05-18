package leetcode.LC_406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 406. Queue Reconstruction by Height
 *
 *
 * KEY is consider the tallest person first,
 * because each person's `k` is ONLY making sense WHEN all the people ahead is not shorter than him!
 */
class Solution406 {
    int[][] reconstructQueue(int[][] people) {
        // Handler corner cases
        if (people == null || people.length == 0 || people[0].length == 0)
            return people;

        // Sort people in their heights' **DESCENDING** order
        Arrays.sort(people, (a, b)->{
            if (a[0] != b[0])
                return b[0] - a[0];
            else
                return a[1] - b[1];
        });

        List<int[]> res = new ArrayList<>();
        for (int[] person : people) {
            final int k = person[1];
            res.add(k, person);
        }
        return res.toArray(new int[res.size()][2]);
    }

    /*
     *
     *
     *
     *
     * A different approach
     *
     *
     *
     *
     */
    int[][] reconstructQueue2(int[][] people) {
        int[][] output = new int[people.length][];

        // Sort people with a PQ
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (p1, p2) -> {
                    if (p1[0] != p2[0]) {
                        return p1[0] - p2[0];
                    } else {
                        return p1[1] - p2[1];
                    }
                }
        );
        for (int[] p : people)
            pq.offer(p);

        // Poll shortest people
        while (!pq.isEmpty()) {
            final int[] person = pq.poll();
            final int h = person[0], k = person[1];

            int i = 0, kk = k;
            while (i < people.length) {
                if (kk == 0 && output[i] == null)
                    break;

                if (output[i] == null || output[i][0] >= h)
                    kk--;
                i++;
            }

            output[i] = person;
        }
        return output;
    }
}
