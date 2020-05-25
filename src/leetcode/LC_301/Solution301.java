package leetcode.LC_301;

import java.util.*;

/**
 * 301. Remove Invalid Parentheses
 */
public class Solution301 {
    /*
     *
     *
     * Approach #1: Optimized
     *
     *
     */
    List<String> removeInvalidParentheses(String s) {
        // Find out the total amounts of misplaced left and right parentheses
        int lefts = 0, rights = 0;
        for (int i = 0; i < s.length(); i++) {
            final char ch = s.charAt(i);
            if (ch == '(') {
                lefts++;
            } else if (ch == ')') {
                if (lefts > 0) {
                    lefts--;
                } else {
                    rights++;
                }
            }
        }

        // Perform DFS
        Set<String> res = new HashSet<>();
        dfs(s, 0, res, new StringBuilder(), lefts, rights, 0);
        return new ArrayList<>(res);
    }

    private void dfs(
            String s, int i,
            Set<String> results, StringBuilder prefix,
            final int lefts, final int rights, final int open   // `open` serves as a simplified Stack here!
    ) {
        // Early return on illegal states
        if (lefts < 0 || rights < 0 || open < 0)
            return;

        // Collect into results if all conditions met
        if (i == s.length()) {
            if (lefts == 0 && rights == 0 && open == 0)
                results.add(prefix.toString());
            return;
        }

        // NOTE THIS BACKTRACK TECHNIQUE!!
        final int len = prefix.length();

        final char c = s.charAt(i);
        if (c == '(') {
            dfs(s, i + 1, results, prefix, lefts - 1, rights, open);		    // not use (
            dfs(s, i + 1, results, prefix.append(c), lefts, rights, open + 1);       // use (

        } else if (c == ')') {
            dfs(s, i + 1, results, prefix, lefts, rights - 1, open);	            // not use  )
            dfs(s, i + 1, results, prefix.append(c), lefts, rights, open - 1);  	    // use )

        } else {
            dfs(s, i + 1, results, prefix.append(c), lefts, rights, open);
        }

        // NOTE THIS BACKTRACK TECHNIQUE!!
        // In this way, we don't have to care if `prefix` has append a char or not. Either way, resetting length will suffice.
        prefix.setLength(len);
    }



    /*
     *
     *
     * Approach #2: not so optimized...
     *
     *
     */
    List<String> removeInvalidParentheses2(String s) {
        // Find out the total amounts of misplaced left and right parentheses
        int lefts = 0, rights = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                lefts++;
            } else if (ch == ')') {
                if (lefts > 0) {
                    lefts--;
                } else {
                    rights++;
                }
            }
        }

        // Perform DFS
        Set<String> results = new HashSet<>();
        dfs2(
                s, 0,
                lefts, rights, 0,
                new StringBuilder(), results);
        return new ArrayList<>(results);
    }

    private void dfs2(
            String s, int index,
            int lefts, int rights, int opens,
            StringBuilder prefix, Set<String> results)
    {
        // Add to result if all status clear
        if (index == s.length()) {
            if (lefts == 0 && rights == 0 && opens == 0)
                results.add(prefix.toString());
            return;
        }

        final int prefixLen = prefix.length();

        final char ch = s.charAt(index);
        if (ch == '(') {
            if (lefts > 0)  // No need to check for conditions here, which can be easily caught on next recursion. See Approach #1.
                dfs2(s, index + 1, lefts - 1, rights, opens, prefix, results);
            dfs2(s, index + 1, lefts, rights, opens + 1, prefix.append(ch), results);

        } else if (ch == ')') {
            if (rights > 0) // No need to check for conditions here, which can be easily caught on next recursion. See Approach #1.
                dfs2(s, index + 1, lefts, rights - 1, opens, prefix, results);

            if (opens == 0) // No need to check for conditions here, which can be easily caught on next recursion. See Approach #1.
                return;
            dfs2(s, index + 1, lefts, rights, opens - 1, prefix.append(ch), results);

        } else {
            dfs2(s, index + 1, lefts, rights, opens, prefix.append(ch), results);
        }

        prefix.setLength(prefixLen);
    }





    /*
     *
     *
     * Approach #3: not optimized
     *
     *
     */
    public List<String> removeInvalidParentheses3(String s) {
        // Find out the total amounts of misplaced left and right parentheses
        int lefts = 0, rights = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                lefts++;
            } else if (ch == ')') {
                if (lefts > 0) {
                    lefts--;
                } else {
                    rights++;
                }
            }
        }

        // Perform DFS
        Set<String> results = new HashSet<>();
        dfs(
                s, 0,
                lefts, rights, new Stack<>(),
                new StringBuilder(), results);
        return new ArrayList<>(results);
    }

    private void dfs(
            String s, int index,
            int lefts, int rights, Stack<Character> stack,
            StringBuilder prefix, Set<String> results)
    {
        if (index == s.length()) {
            // Add to result if all status clear
            if (lefts == 0 && rights == 0 && stack.isEmpty())
                results.add(prefix.toString());
            return;
        }

        final char ch = s.charAt(index);
        if (ch == '(') {
            if (lefts > 0)
                dfs(s, index + 1, lefts - 1, rights, stack, prefix, results);

            stack.push('(');
            prefix.append(ch);
            dfs(s, index + 1, lefts, rights, stack, prefix, results);
            prefix.deleteCharAt(prefix.length() - 1);   // No need to discuss backtrack on each case. See Approach #2.
            stack.pop();

        } else if (ch == ')') {
            if (rights > 0)
                dfs(s, index + 1, lefts, rights - 1, stack, prefix, results);

            // In fact we can replace this stack with a `open` int, since we don't need to differentiate different parentheses in this stack.
            // See Approach #1 above!
            if (stack.isEmpty())
                return;

            stack.pop();
            prefix.append(ch);
            dfs(s, index + 1, lefts, rights, stack, prefix, results);
            prefix.deleteCharAt(prefix.length() - 1);   // No need to discuss backtrack on each case. See Approach #2.
            stack.push('(');

        } else {
            prefix.append(ch);
            dfs(s, index + 1, lefts, rights, stack, prefix, results);
            prefix.deleteCharAt(prefix.length() - 1);   // No need to discuss backtrack on each case. See Approach #2.
        }
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