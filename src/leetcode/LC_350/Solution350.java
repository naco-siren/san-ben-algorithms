package leetcode.LC_350;

import java.util.*;

/**
 * 350. Intersection of Two Arrays II
 */
class Solution350 {


    /*
     *
     *
     * Approach #1: Sort & Two Pointers using Array
     *
     *
     */
    int[] intersect(int[] nums1, int[] nums2) {
        final int len1 = nums1.length, len2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);


        int[] result = new int[Math.min(len1, len2)];
        int i = 0, j = 0, w = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] == nums2[j]) {
                result[w++] = nums1[i];
                i++; j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        return Arrays.copyOf(result, w);
    }

    /*
     *
     *
     * Approach #2: Sort & Two Pointers using List
     *
     *
     */
    int[] intersect2(int[] nums1, int[] nums2) {
        final int len1 = nums1.length, len2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> results = new ArrayList<>(Math.min(len1, len2));
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length){
            if (nums1[i] == nums2[j]) {
                results.add(nums1[i]);
                i++;
                j++;

            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        // Format to output
        int[] output = new int[results.size()];
        int id = 0;
        for (Integer r : results)
            output[id++] = r;
        return output;
    }


    /*
     *
     *
     * Approach #3: Map
     *
     *
     */
    int[] intersectWithMap(int[] nums1, int[] nums2) {
        // Calculate first array's histogram
        Map<Integer, Integer> histogram1 = new HashMap<>();
        for (int num : nums1) {
            Integer count = histogram1.getOrDefault(num, 0);
            histogram1.put(num, count + 1);
        }

        // Calculate intersection histogram
        Map<Integer, Integer> intersection = new HashMap<>();
        for (int num : nums2) {
            if (histogram1.containsKey(num)) {
                Integer count1 = histogram1.getOrDefault(num, 0);
                Integer count2 = intersection.getOrDefault(num, 0);
                intersection.put(num, Math.min(count1, count2 + 1));
            }
        }

        // Collect into a list
        List<Integer> results = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : intersection.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            while (count-- > 0)
                results.add(num);
        }

        // Format to output
        int[] output = new int[results.size()];
        int id = 0;
        for (Integer r : results)
            output[id++] = r;
        return output;
    }
}
