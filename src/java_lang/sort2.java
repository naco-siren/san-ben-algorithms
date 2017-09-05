package java_lang;

import java.util.*;

/**
 * Created by naco_siren on 8/23/17.
 */
public class sort2 implements Comparable<sort2> {
    private int val = 0;
    public sort2(int value){
        this.val = value;
    }

    @Override
    public int compareTo(sort2 o) {
        return val - o.val;
    }

    public static void main(String[] args) {

//        int[] arr1 = new int[]{1, 4, 2, 8, 5 ,7};
//        quickSort(arr1);

        int[] arr2 = new int[]{5, 2, 4, 1, 3, 6, 0};
        Arrays.sort(arr2);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(4);
        list.add(1);
        list.add(3);
        list.add(6);
        list.add(0);
        Collections.sort(list);
        Collections.reverse(list);

        PriorityQueue<sort2> priorityQueue = new PriorityQueue<>();
        sort2 s2 = new sort2(22); priorityQueue.add(s2);
        sort2 s1 = new sort2(1); priorityQueue.add(s1);
        sort2 s3 = new sort2(333); priorityQueue.add(s3);


        return;
    }



}
