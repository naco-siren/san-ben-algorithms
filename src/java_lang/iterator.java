package java_lang;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by naco_siren on 8/28/17.
 */
public class iterator {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(i);

        ListIterator<Integer> iter = list.listIterator();
        int i1 = iter.next();
        int i2 = iter.next();
        iter.remove();
        int i3 = iter.next();

        return;
    }
}
