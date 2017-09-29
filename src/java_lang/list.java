package java_lang;

import java.util.*;

/**
 * Created by naco_siren on 7/30/17.
 */
public class list {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(22);
        list.add(333);
        for (Integer integer : list) {
            int x = integer;
        }
        list.removeLast();

        Collections.fill(list, 7);
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(22);
        arrayList.add(333);


        List<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(22);
        list1.add(333);
        ListIterator<Integer> iterator = list1.listIterator();
        int n1 = iterator.next();
        int n2 = iterator.next();
        int n3 = iterator.next();
        int n4 = iterator.next();
        return;
    }

}
