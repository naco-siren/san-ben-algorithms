package java_lang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

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

        return;
    }
}
