package companies.zillow.unique_character;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by naco_siren on 10/3/17.
 */
public class Solution {
    public static void main(String... args){
        Character r1 = findUniqueChar("aebacddeafgjf"); // [b]

        return;
    }



    public static Character findUniqueChar(String input) {
        int len = input.length();

        HashSet<Character> uniques = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            char ch = input.charAt(i);

            if (map.containsKey(ch)) {
                uniques.remove(ch);
            } else {
                uniques.add(ch);
                map.put(ch, i);
            }
        }

        int minIdx = Integer.MAX_VALUE;
        Character retval = null;
        for (char ch : uniques) {
            Integer idx = map.get(ch);
            if (idx != null && idx < minIdx) {
                retval = ch;
                minIdx = idx;
            }
        }
        return retval;
    }

}
