package companies.google.flower_permutation;

import java.util.TreeSet;

/**
 * Created by naco_siren on 9/15/17.
 */
public class FlowerPerm {
    public static void main(String[] args) {
        int r1 = findDate(new int[]{3, 1, 4, 5, 2}, 2);

        return;
    }


    private static int findDate(int[] perm, int k) {
        int len = perm.length;

        /* Generate an array to use date to index flower */
        int[] indexes = new int[len];
        for (int i = 0; i < len; i++) {
            indexes[perm[i]-1] = i + 1;
        }

        /* Add the border to the TreeSet */
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0); set.add(len + 1);

        /* Add the flower's position to the TreeSet once a day */
        for (int i = 0; i < len; i++) {
            int index = indexes[i];

            /* Find the nearest flower's position on the left */
            int floor = set.floor(index);
            if (index - floor - 1 == k) return i + 1;

            /* Find the nearest flower's position on the right */
            int ceiling = set.ceiling(index);
            if (ceiling - index - 1 == k) return i + 1;

            set.add(indexes[i]);
        }

        return -1;
    }
}
