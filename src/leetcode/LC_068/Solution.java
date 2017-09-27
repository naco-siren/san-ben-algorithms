package leetcode.LC_068;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naco_siren on 9/18/17.
 */
public class Solution {
    public static void main(String[] args) {

        String[] words1 = new String[]{"a"};
        Solution solution1 = new Solution(words1, 1);
        List<String> results1 = solution1.fullJustify();

        String[] words2 = new String[]{"What", "must", "be", "shall", "be."};
        Solution solution2 = new Solution(words2, 12);
        List<String> results2 = solution2.fullJustify();

        return;
    }


    private String[] _words;
    private int _maxWidth;

    public Solution(String[] words, int maxWidth) {
        _words = words;
        _maxWidth = maxWidth;
    }

    public List<String> fullJustify() {
        ArrayList<String> results = new ArrayList<>();
        if(_words == null || _words.length == 0)
            return results;

        int first = 0;
        while (first < _words.length){
            int last = first, nchar = 0;
            while (last < _words.length && nchar + _words[last].length() + last - first <= _maxWidth){
                nchar += _words[last].length();
                last++;
            }

            String line = transformLine(first, last - 1, nchar);
            results.add(line);

            first = last;
        }
        return results;
    }

    private String transformLine(int first, int last, int nchar){
        int s = (first == last || last == _words.length - 1) ? 1 : (_maxWidth - nchar) / (last - first); // word[start+t+1] ~ word[last-1] has s blanks
        int t = (first == last || last == _words.length - 1) ? 0 : _maxWidth - nchar - (last - first) * s; // word[start] ~ word[start + t] has (s+1) blanks
        int r = _maxWidth - nchar - (last - first) * s - t; // blanks after word[last]

        StringBuilder builder = new StringBuilder(_words[first]);
        for(int i = 1; first + i <= last; i++){
            int times = i <= t ? s + 1 : s;
            for(int k = 0; k < times; k++)
                builder.append(' ');
            builder.append(_words[first + i]);
        }
        for(int k = 0; k < r; k++)
            builder.append(' ');

        return builder.toString();
    }
}
