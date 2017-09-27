package leetcode.LC_331;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by naco_siren on 9/26/17.
 */
public class Solution {

    public static void main(String[] args) {

        List<String> r1 = removeInvalidParentheses("()())");

        return;
    }

    public static List<String> removeInvalidParentheses(String s) {
        int rmL = 0, rmR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                rmL++;
            } else if (s.charAt(i) == ')') {
                if (rmL != 0) {
                    rmL--;
                } else {
                    rmR++;
                }
            }
        }
        Set<String> res = new HashSet<>();
        dfs(s, 0, res, new StringBuilder(), rmL, rmR, 0);
        return new ArrayList<String>(res);
    }

    public static void dfs(String s, int i, Set<String> res, StringBuilder sb, int rmL, int rmR, int open) {
        if (rmL < 0 || rmR < 0 || open < 0)
            return;

        if (i == s.length()) {
            if (rmL == 0 && rmR == 0 && open == 0)
                res.add(sb.toString());

            return;
        }

        char c = s.charAt(i);
        int len = sb.length();

        if (c == '(') {
            dfs(s, i + 1, res, sb, rmL - 1, rmR, open);		    // not use (
            dfs(s, i + 1, res, sb.append(c), rmL, rmR, open + 1);       // use (

        } else if (c == ')') {
            dfs(s, i + 1, res, sb, rmL, rmR - 1, open);	            // not use  )
            dfs(s, i + 1, res, sb.append(c), rmL, rmR, open - 1);  	    // use )

        } else {
            dfs(s, i + 1, res, sb.append(c), rmL, rmR, open);
        }

        sb.setLength(len);
    }


//    public List<String> removeInvalidParentheses(String s) {
//        _results = new HashSet<String>();
//        if(s == null)
//            return new ArrayList<>(_results);
//
//        _s = s;
//        recur("", 0, 0, 0);
//
//        return new ArrayList<>(_results);
//    }
//
//    private String _s;
//    private HashSet<String> _results;
//
//
//    private void recur(String prefix, int first, int nl, int nr){
//        // Preprune if length impossible or prefix invalid
//        if(_results.isEmpty() == false && prefix.length() > _results.iterator().next().length())
//            return;
//        if(_results.isEmpty() == false && prefix.length() + _s.length() - first < _results.iterator().next().length())
//            return;
//        if(nl < nr)
//            return;
//
//        // Add alphabetical chars until the end or a bracket
//        StringBuilder builder = new StringBuilder(prefix);
//        for(; first < _s.length() && Character.isLetter(_s.charAt(first)); first++){
//            builder.append(_s.charAt(first));
//        }
//
//        // Reach string end
//        if(first == _s.length()){
//            if(nl == nr)
//                _results.add(builder.toString());
//            return;
//        }
//
//        // Recursion
//        if(_s.charAt(first) == '('){
//            recur(builder.toString() + "(", first + 1, nl + 1, nr);
//        } else {
//            recur(builder.toString() + ")", first + 1, nl, nr + 1);
//        }
//        recur(builder.toString(), first + 1, nl, nr);
//    }

}