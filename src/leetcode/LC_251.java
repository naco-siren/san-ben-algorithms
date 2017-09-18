package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by naco_siren on 9/17/17.
 */
public class LC_251 implements Iterator<Integer> {

    public static void main(String[] args) {
        List<List<Integer>> data = new ArrayList<>();

        List<Integer> row1 = new ArrayList<>();
        row1.add(1); row1.add(2); row1.add(3);
        data.add(row1);

        List<Integer> row2 = new ArrayList<>();
        data.add(row2);

        List<Integer> row3 = new ArrayList<>();
        data.add(row3);

        List<Integer> row4 = new ArrayList<>();
        row4.add(4);
        data.add(row4);

        List<Integer> row5 = new ArrayList<>();
        row5.add(5); row5.add(6);
        data.add(row5);

        List<Integer> row6 = new ArrayList<>();
        data.add(row6);


        LC_251 lc = new LC_251(data);
        while (lc.hasNext()) {
            Integer num = lc.next();
            System.out.println(num);

            if (num == 4) {
                lc.remove();
                System.out.println("Removed 4!");
            }

        }

        return;
    }

    private ListIterator<List<Integer>> iter;
    private ListIterator<Integer> iter2;

    public LC_251(List<List<Integer>> data){
        if (data == null) return;
        this.iter = data.listIterator();
    }

    @Override
    public boolean hasNext() {
        if (iter2 != null && iter2.hasNext())
            return true;

        while (iter.hasNext()) {
            List<Integer> list = iter.next();
            if (!list.isEmpty()) {
                iter2 = list.listIterator();
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        return iter2.next();
    }

    @Override
    public void remove() {
        iter2.remove();
    }
}
