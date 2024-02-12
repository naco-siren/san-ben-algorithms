package base;

import java.util.Arrays;

public class TestHelpers {
    public static boolean matrixEquals(int[][] m1, int[][] m2) {
        if (m1 == m2)
            return true;
        if (m1 == null || m2 == null)
            return false;

        int length = m1.length;
        if (m2.length != length)
            return false;

        for (int i=0; i<length; i++) {
            int[] o1 = m1[i];
            int[] o2 = m2[i];
            if (!(o1==null ? o2==null : Arrays.equals(o1, o2)))
                return false;
        }
        return true;
    }

    public static <T> boolean matrixEquals(T[][] m1, T[][] m2) {
        if (m1 == m2)
            return true;
        if (m1 == null || m2 == null)
            return false;

        int length = m1.length;
        if (m2.length != length)
            return false;

        for (int i=0; i<length; i++) {
            T[] o1 = m1[i];
            T[] o2 = m2[i];
            if (!(o1==null ? o2==null : Arrays.equals(o1, o2)))
                return false;
        }
        return true;
    }
}
