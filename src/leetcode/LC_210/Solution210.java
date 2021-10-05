package leetcode.LC_210;

import java.util.*;

/**
 * 210. Course Schedule II
 */
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];

        // Map prerequisite course id to their next dependants
        Map<Integer, Set<Integer>> pre2dep = new HashMap<>();
        for (int[] pair : prerequisites) {
            final int course = pair[0], pre = pair[1];
            inDegrees[course]++;
            pre2dep.computeIfAbsent(pre, irre -> new HashSet<>()).add(course);
        }

        // Start with 0 in-degree nodes
        Queue<Integer> candidates = new LinkedList<>();
        for (int courseId = 0; courseId < numCourses; courseId++) {
            if (inDegrees[courseId] == 0) {
                candidates.offer(courseId);
            }
        }

        // Topological sort
        List<Integer> result = new LinkedList<>();
        while (!candidates.isEmpty()) {
            final Integer prerequisite = candidates.poll();
            result.add(prerequisite);

            // Check if there are next courses
            Set<Integer> dependants = pre2dep.get(prerequisite);
            if (dependants == null)
                continue;

            // If so, adjust their in-degrees and add to candidates upon 0
            for (Integer next : dependants) {
                final int inDegree = inDegrees[next];
                if (inDegree == 1)
                    candidates.add(next);
                inDegrees[next]--;
            }
        }

        // Format to output
        if (result.size() != numCourses) {
            return new int[0];
        } else {
            int[] resultArr = new int[numCourses];
            int index = 0;
            for (Integer course : result)
                resultArr[index++] = course;
            return resultArr;
        }
    }
}
