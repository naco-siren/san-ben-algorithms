package java_lang;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by naco_siren on 8/25/17.
 */
public class set {
    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();

        TreeSet<Integer> treeset = new TreeSet<>();
        treeset.add(1);
        treeset.add(2);
        treeset.add(5);
        treeset.add(8);
        treeset.add(12);

        int c1 = treeset.ceiling(10);
        int c2 = treeset.ceiling(9);
        int c3 = treeset.ceiling(8);



        return;
    }
}
