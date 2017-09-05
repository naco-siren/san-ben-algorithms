package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by naco_siren on 8/2/17.
 */
public class HR_404 {

    public static void main(String[] args) {
        socialGraphs(new int[]{3,2,2,3,4,3,4,3,4,3,4,3});


        return;
    }

    static void socialGraphs(int[] counts) {
        HashMap<Integer, Integer> ids = new HashMap<>(counts.length);
        HashMap<Integer, Integer> lens = new HashMap<>(counts.length);

        int groupId = 0;
        HashMap<Integer, ArrayList<Integer>> groups = new HashMap<>(counts.length);

        for (int i = 0; i < counts.length; i++) {
            int size = counts[i];

            if (ids.containsKey(size)) {
                int id = ids.get(size);
                int len = lens.get(size);

                ArrayList<Integer> group = groups.get(id);
                group.add(i);

                if (len == size - 1) {
                    ids.remove(size);
                    lens.remove(size);
                } else {
                    lens.put(size, len + 1);
                }

            } else {
                ArrayList<Integer> group = new ArrayList<Integer>(size);
                group.add(i);
                groups.put(groupId, group);

                if (size > 1) {
                    ids.put(size, groupId);
                    lens.put(size, 1);
                }

                groupId++;
            }
        }

        for (int i = 0; i < groupId; i++) {
            ArrayList<Integer> group = groups.get(i);
            for (Integer member : group) {
                System.out.print(member);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
