package companies.twitter.genetic_mutations;

import java.util.*;

/**
 * Created by naco_siren on 11/20/17.
 */
public class Solution {

    public static void main(String[] args) {
        int r1 = findMutationDistance("AAAAAAAA", "GGAAAAAA", new String[] {
                "GAAAAAAA",
                "AAGAAAAA",
                "AAAAGAAA",
                "GGAAAAAA"
        });
        return;
    }

    static int findMutationDistance(String start, String end, String[] bank) {
        int N = bank.length;

        /* Add all the genes into a set for indexing */
        HashSet<String> set = new HashSet<>();
        for (String gene : bank)
            set.add(gene);
        if (!set.contains(end))
            return -1;

        /* Perform a BFS */
        LinkedList<String> queue = new LinkedList<>();
        queue.add(start);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String gene = queue.poll();
                if (gene.equals(end))
                    return level;

                for (String mutation : getMutations(gene)) {
                    if (set.contains(mutation)) {
                        queue.offer(mutation);
                        set.remove(mutation);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    static final char[] NUCLEOTIDES = new char[]{'A', 'T', 'C', 'G'};
    static List<String> getMutations(String source) {
        int n = source.length();
        StringBuilder sb = new StringBuilder(source);

        List<String> mutations = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char ch = source.charAt(i);
            for (char nucleotide : NUCLEOTIDES) {
                if (nucleotide == ch)
                    continue;

                sb.setCharAt(i, nucleotide);
                mutations.add(sb.toString());
            }
            sb.setCharAt(i, ch);
        }
        return mutations;
    }


}
