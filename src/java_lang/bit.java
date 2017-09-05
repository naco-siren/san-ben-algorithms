package java_lang;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by naco_siren on 8/2/17.
 */
public class bit {
    public static void main(String[] args) {
        int a = 6;
        int c = Integer.bitCount(a);

        int[] arr = new int[] {5, 3, 7, 10, 14};

        int x = -7;
        int y = ~x;

        // INT_MIN's one's compliment & two's compliment
        int xx = Integer.MIN_VALUE;
        int yy = ~xx;

        int zz0 = 0 - xx;
        int zz1 = 1 - xx;
        int zz2 = 2 - xx;



        int base = 0;
        String str = "abcdbcd";
        for (char ch : str.toCharArray())
            base ^= ch;
        char uniq = (char) base;
        return;
    }
}
