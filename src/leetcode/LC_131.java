package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by naco_siren on 8/16/17.
 */
public class LC_131 {
    public static void main(String[] args) {
        LC_131 lc = new LC_131();

        lc.partition("aab");

        return;
    }


    public List<List<String>> partition(String s) {
        str = s; len = s.length();

        isp = new boolean[len][];
        for (int i = 0; i < len; i++) isp[i] = new boolean[len];

        for (int c = 0; c < len * 2 - 1; c++) {
            int l = c/2, r = (c+1)/2;
            for (; l >= 0 && r <= len - 1 && s.charAt(l) == s.charAt(r); l--, r++)
                isp[l][r] = true;
        }

        results = new ArrayList<>();
        LinkedList<String> prefix = new LinkedList<>();
        recur(0, prefix);

        return results;
    }

    String str;
    int len;
    boolean[][] isp;
    ArrayList<List<String>> results;

    private void recur(int l, LinkedList<String> prefix) {
        if (l == len) {
            results.add(new LinkedList<String>(prefix));
            return;
        }

        prefix.add("");
        for (int r = l; r < len; r++) {
            if (isp[l][r] == false) continue;
            prefix.removeLast();
            prefix.add(str.substring(l, r+1));
            recur(r + 1, prefix);
        }
        prefix.removeLast();
    }
}
