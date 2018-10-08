package companies.zillow.intersection_of_two_int_arrays;

import java.util.*;

/**
 * Created by naco_siren on 10/3/17.
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 5, 2, 4, 2, 2, 6};
        int[] arr2 = new int[]{5, 2, 5, 4, 2};

        List<Integer> r1 = getIntersections1(arr1, arr2); // [4, 5, 2, 2]
        List<Integer> r2 = getIntersections2(arr1, arr2); // [4, 5, 2, 2]

        return;
    }

    public static List<Integer> getIntersections2(int[] arr1, int[] arr2){
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        LinkedList<Integer> result = new LinkedList<>();
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                result.add(arr1[i]);
                i++; j++;

            } else if (arr1[i] > arr2[j]) {
                j++;

            } else {
                i++;
            }
        }
        return result;
    }


    public static List<Integer> getIntersections1(int[] arr1, int[] arr2){
        HashMap<Integer, Integer> map1 = mapIntArray(arr1);
        HashMap<Integer, Integer> map2 = mapIntArray(arr2);

        LinkedList<Integer> result = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int num = entry.getKey(), count1 = entry.getValue();

            Integer count2 = map2.get(num);
            for (int i = 0; i < (count2 == null ? 0 : Math.min(count1, count2)); i++)
                result.add(num);
        }
        return result;
    }

    private static HashMap<Integer, Integer> mapIntArray(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>(arr.length);
        for (int num : arr) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, count + 1);
            }
        }
        return map;
    }
}
