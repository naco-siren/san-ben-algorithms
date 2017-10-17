package java_lang;

import java.util.*;

/**
 * Created by naco_siren on 8/2/17.
 */
public class map {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        map.put(0, list);

        ArrayList<Integer> list2 = map.get(0);
        list2.add(3);

        map.remove(0);
        boolean i = map.containsKey(0);

        /* Map VS Table */
        map.put(null, null);
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        //hashtable.put(5, null);


        /* LinkedHashMap */
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "One");
        linkedHashMap.put(2, "Two");
        linkedHashMap.put(3, "Three");

        Set<Map.Entry<Integer, String>> entrySet = linkedHashMap.entrySet();


        /* Map of collections */
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(1); l1.add(2); l1.add(3);

        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(1); l2.add(2); l2.add(3);

        HashMap<LinkedList<Integer>, Integer> map1 = new HashMap<>();
        map1.put(l1, 111);
        Integer i1 = map1.get(l2);

        map1.put(l2, 22);

        return;
    }
}
