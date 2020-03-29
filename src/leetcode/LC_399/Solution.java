package leetcode.LC_399;

import java.util.*;

/**
 * 399. Evaluate Division
 *
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 */
public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Initialize a dictionary
        Map<String, Map<String, Double>> dict = buildDict(equations, values);

        // Perform DFS on each query
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            final List<String> query = queries.get(i);
            results[i] = calc(query.get(0), query.get(1), dict);
        }
        return results;
    }

    Map<String, Map<String, Double>> buildDict(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> dict = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            final String op1 = equation.get(0), op2 = equation.get(1);

            Map<String, Double> map1 = dict.getOrDefault(op1, new HashMap<>());
            map1.put(op2, values[i]);
            dict.put(op1, map1);

            Map<String, Double> map2 = dict.getOrDefault(op2, new HashMap<>());
            map2.put(op1, 1d / values[i]);
            dict.put(op2, map2);
        }
        return dict;
    }

    double calc(final String op1, final String op2, final Map<String, Map<String, Double>> dict) {
        if (!dict.containsKey(op1) || !dict.containsKey(op2))
            return -1.0;

        if (op1.equals(op2))
            return 1.0;

        Stack<String> opStack = new Stack<>();
        Stack<Double> valStack = new Stack<>();
        opStack.push(op1);
        valStack.push(1.0);
        Set<String> visited = new HashSet<>();
        visited.add(op1);
        while (!opStack.isEmpty()) {
            final String op = opStack.pop();
            final Double val = valStack.pop();

            if (op.equals(op2))
                return val;

            dict.get(op1).put(op, val);

            Map<String, Double> map = dict.get(op);
            for (Map.Entry<String, Double> cand : map.entrySet()) {
                if (!visited.contains(cand.getKey())) {
                    opStack.push(cand.getKey());
                    valStack.push(cand.getValue() * val);
                    visited.add(cand.getKey());
                }
            }
        }
        return -1;
    }
}
