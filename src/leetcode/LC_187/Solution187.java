package leetcode.LC_187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 187. Repeated DNA Sequences
 */
class Solution187 {
    private static final int SEQUENCE_LENGTH = 10;

    List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10)
            throw new IllegalArgumentException("DNA has to be at least 10 digits long!");

        ArrayList<String> output = new ArrayList<>();

        // Check every 10-digit DNA subsequece
        HashMap<Integer, Integer> occurrences = new HashMap<>();
        for (int i = 0; i <= s.length() - SEQUENCE_LENGTH; i++) {
            final String subsequence = s.substring(i, i + SEQUENCE_LENGTH);
            final int encoded = encodeTenDigitDnaSeq(subsequence);

            final int occurrence = occurrences.getOrDefault(encoded, 0);
            if (occurrence == 0) {
                occurrences.put(encoded, 1);
            } else {
                if (occurrence == 1)
                    output.add(subsequence);
                occurrences.put(encoded, occurrence + 1);
            }
        }

        return output;
    }

    /**
     * Big-Endian encoding
     * @param sequence
     * @return
     */
    int encodeTenDigitDnaSeq(String sequence) {
        if (sequence == null || sequence.length() != SEQUENCE_LENGTH)
            throw new IllegalArgumentException("DNA sequence has to be 10 digits long!");

        int val = 0;
        for (int i = 0; i < sequence.length(); i++) {
            val <<= 2;
            val += nucleotideToTwoBits(sequence.charAt(i));
        }
        return val;
    }

    private static final int UPDATE_MASK = 0b00000000_00000011_11111111_11111111;

    int shiftTenDigitDnaSeqEncoding(int hash, char newCh) {
//        hash <<= 4;
//        hash >>= 2;
//        return hash + nucleotideToTwoBits(newCh);

        hash &= UPDATE_MASK;
        hash <<= 2;
        return hash + nucleotideToTwoBits(newCh);
    }

    private int nucleotideToTwoBits(char ch) {
        switch (ch) {
            case 'A':
                return 0;
            case 'T':
                return 1;
            case 'C':
                return 2;
            case 'G':
                return 3;
            default:
                throw new IllegalArgumentException("Not a legal nucleotide: " + ch);
        }
    }
}
