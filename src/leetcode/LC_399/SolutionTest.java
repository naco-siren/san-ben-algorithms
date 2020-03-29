package leetcode.LC_399;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void calcEquation_0() {
        Solution solution = new Solution();

        // Initialize equations
        final List<List<String>> equations = new ArrayList<>();

        List<String> equation = new ArrayList<>();
        equation.add("a"); equation.add("b");
        equations.add(equation);

        equation = new ArrayList<>();
        equation.add("b"); equation.add("c");
        equations.add(equation);

        // Initialize corresponding values
        final double[] values = new double[]{2.0, 3.0};

        // Initialize queries
        List<List<String>> queries = new ArrayList<>();

        List<String> query = new ArrayList<>();
        query.add("a"); query.add("c");
        queries.add(query);

        query = new ArrayList<>();
        query.add("b"); query.add("a");
        queries.add(query);

        query = new ArrayList<>();
        query.add("a"); query.add("e");
        queries.add(query);

        query = new ArrayList<>();
        query.add("a"); query.add("a");
        queries.add(query);

        query = new ArrayList<>();
        query.add("x"); query.add("x");
        queries.add(query);

        // Perform calculation and check for results
        final double[] results = solution.calcEquation(equations, values, queries);
        assertArrayEquals(new double[]{6.0, 0.5, -1.0, 1.0, -1.0 }, results, 0.000000001);
    }

    @Test
    public void calcEquation_1() {
        Solution solution = new Solution();

        // Initialize equations
        final List<List<String>> equations = new ArrayList<>();

        List<String> equation = new ArrayList<>();
        equation.add("x1"); equation.add("x2");
        equations.add(equation);

        equation = new ArrayList<>();
        equation.add("x2"); equation.add("x3");
        equations.add(equation);

        equation = new ArrayList<>();
        equation.add("x3"); equation.add("x4");
        equations.add(equation);

        equation = new ArrayList<>();
        equation.add("x4"); equation.add("x5");
        equations.add(equation);

        // Initialize corresponding values
        final double[] values = new double[]{3.0, 4.0, 5.0, 6.0};

        // Initialize queries
        List<List<String>> queries = new ArrayList<>();

        List<String> query = new ArrayList<>();
        query.add("x1"); query.add("x5");
        queries.add(query);

        query = new ArrayList<>();
        query.add("x5"); query.add("x2");
        queries.add(query);

        query = new ArrayList<>();
        query.add("x2"); query.add("x4");
        queries.add(query);

        query = new ArrayList<>();
        query.add("x2"); query.add("x2");
        queries.add(query);

        query = new ArrayList<>();
        query.add("x2"); query.add("x9");
        queries.add(query);

        query = new ArrayList<>();
        query.add("x9"); query.add("x9");
        queries.add(query);

        // Perform calculation and check for results
        final double[] results = solution.calcEquation(equations, values, queries);
        assertArrayEquals(new double[]{360.0, 0.0083333333, 20.0, 1.0, -1.0, -1.0 }, results, 0.000000001);
    }
}