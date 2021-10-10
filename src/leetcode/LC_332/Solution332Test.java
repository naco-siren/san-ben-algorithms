package leetcode.LC_332;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Solution332Test {
    @Test
    public void findItinerary_1() {
        List<List<String>> tickets = new ArrayList<>();
        List<String> t1 = Arrays.asList("MUC","LHR");   tickets.add(t1);
        List<String> t2 = Arrays.asList("JFK","MUC");   tickets.add(t2);
        List<String> t3 = Arrays.asList("SFO","SJC");   tickets.add(t3);
        List<String> t4 = Arrays.asList("LHR","SFO");   tickets.add(t4);

        final String[] expected = new String[]{"JFK","MUC","LHR","SFO","SJC"};

        final List<String> itinerary = new Solution332().findItinerary(tickets);
        String[] result = new String[itinerary.size()];
        itinerary.toArray(result);

        assertArrayEquals(expected, result);
    }

    @Test
    public void findItinerary_2() {
        List<List<String>> tickets = new ArrayList<>();
        List<String> t1 = Arrays.asList("JFK","SFO");   tickets.add(t1);
        List<String> t2 = Arrays.asList("JFK","ATL");   tickets.add(t2);
        List<String> t3 = Arrays.asList("SFO","ATL");   tickets.add(t3);
        List<String> t4 = Arrays.asList("ATL","JFK");   tickets.add(t4);
        List<String> t5 = Arrays.asList("ATL","SFO");   tickets.add(t5);

        final String[] expected = new String[]{"JFK","ATL","JFK","SFO","ATL","SFO"};

        final List<String> itinerary = new Solution332().findItinerary(tickets);
        String[] result = new String[itinerary.size()];
        itinerary.toArray(result);

        assertArrayEquals(expected, result);
    }

    @Test
    public void findItinerary_3() {
        List<List<String>> tickets = new ArrayList<>();
        List<String> t1 = Arrays.asList("JFK","KUL");   tickets.add(t1);
        List<String> t2 = Arrays.asList("JFK","NRT");   tickets.add(t2);
        List<String> t3 = Arrays.asList("NRT","JFK");   tickets.add(t3);

        final String[] expected = new String[]{"JFK","NRT","JFK","KUL"};

        final List<String> itinerary = new Solution332().findItinerary(tickets);
        String[] result = new String[itinerary.size()];
        itinerary.toArray(result);

        assertArrayEquals(expected, result);
    }

}