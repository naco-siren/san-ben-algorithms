package companies.twitter.timeseries_data_aggregation;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception {
        Solution solution = new Solution();
        try {
            solution.solve(new InputStreamReader(solution.getClass().getResourceAsStream("input000.txt")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    int[] start;
    int[] end;
    public Solution() {
    }

    public void solve(InputStreamReader inputStreamReader) throws Exception {
        /* Read start and end of requested date interval */
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line = reader.readLine();
        String[] parts = line.split(",");
        start = parseDate(parts[0]);
        end = parseDate(parts[1]);
        reader.readLine();

        /* Prepare bundles to count each month's engagements */
        int outputSize = monthToOffset(start, end);
        OutputBundle[] bundles = new OutputBundle[outputSize];
        for (int i = 0; i < outputSize; i++)
            bundles[i] = new OutputBundle(offsetToMonth(start, i), i);

        /* Read data points and collect into bundles */
        while ((line = reader.readLine()) != null) {
            /* Parse date, type and num from line */
            parts = line.split(",");
            int[] date = parseDate(parts[0]);
            String type = parts[1].trim();
            int num = Integer.parseInt(parts[2].trim());

           /* Neglect record not in query interval */
            int offset = monthToOffset(start, new int[]{date[0], date[1]});
            if (offset < 0 || offset >= outputSize)
                continue;

            /* Add them into corresponding bundle */
            OutputBundle bundle = bundles[offset];
            int count = bundle.map.getOrDefault(type, 0);
            bundle.map.put(type, count + num);
        }

        /* Output bundles to System.out */
        for (int i = outputSize - 1; i >=0; i--) {
            /* Skip the empty bundles */
            OutputBundle bundle = bundles[i];
            int size = bundle.map.size();
            if (size == 0)
                continue;

            /* Output as String */
            System.out.print(bundle.monthStr + ", ");
            int idx = 0;
            for (Map.Entry<String, Integer> entry : bundle.map.entrySet()) {
                if (idx < size - 1) {
                    System.out.print(entry.getKey() + ", " + entry.getValue() + ", ");
                } else {
                    System.out.println(entry.getKey() + ", " + entry.getValue());
                }
                idx++;
            }
        }

    }

    private static int[] parseDate(String str) {
        String[] parts = str.trim().split("-");
        int[] output = new int[parts.length];
        for (int i = 0; i < parts.length; i++)
            output[i] = Integer.parseInt(parts[i]);
        return output;
    }

    private static int monthToOffset(int[] date1, int[] date2) {
        return (date2[0] - date1[0]) * 12 + (date2[1] - date1[1]);
    }

    private static String offsetToMonth(int[] base, int offset) {
        int month = base[1] + offset - 1;
        int year = base[0] + month / 12;
        month = month % 12 + 1;
        return "" + year + "-" + (month < 10 ? "0" : "") + month;
    }

    public class OutputBundle {
        String monthStr;
        int offset;
        TreeMap<String, Integer> map;

        public OutputBundle(String monthStr, int offset) {
            this.monthStr = monthStr;
            this.offset = offset;
            this.map = new TreeMap<>();
        }
    }
}







