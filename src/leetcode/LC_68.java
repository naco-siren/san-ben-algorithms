package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naco_siren on 9/18/17.
 */
public class LC_68 {
    public static void main(String[] args) {
        LC_68 lc = new LC_68();

        String[] words1 = new String[]{"a"};
        List<String> results1 = lc.fullJustify(words1, 1);

        String[] words2 = new String[]{"What", "must", "be", "shall", "be."};
        List<String> results2 = lc.fullJustify(words2, 12);



        return;
    }


    public List<String> fullJustify(String[] words, int maxWidth) {
        _words = words;
        _maxWidth = maxWidth;

        ArrayList<String> results = new ArrayList<>();
        if(words == null || words.length == 0)
            return results;

        int first = 0;
        while (first < words.length){
            int last = first, nchar = 0;
            while (last < words.length && nchar + words[last].length() + last - first <= maxWidth){
                nchar += words[last].length();
                last++;
            }

            String line = transformLine(first, last - 1, nchar);
            results.add(line);

            first = last;
        }
        return results;
    }

    private String[] _words;
    private int _maxWidth;

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
