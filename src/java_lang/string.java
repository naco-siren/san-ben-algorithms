package java_lang;

/**
 * Created by naco_siren on 8/16/17.
 */
public class string {
    public static void main(String[] args) {
        String a = "ABCxyz %$#!";

        boolean b1 = Character.isAlphabetic('c');
        boolean b2 = Character.isAlphabetic('9');
        boolean b3 = Character.isAlphabetic('!');

        boolean b4 = Character.isLetterOrDigit('c');
        boolean b5 = Character.isLetterOrDigit('9');
        boolean b6 = Character.isLetterOrDigit('!');

        //Character.toLowerCase()

        String str = "abcdefg";
        int len = str.length();
        String sub1 = str.substring(1, 1);
        String sub2 = str.substring(1, 2);
        String sub3 = str.substring(1, 3);

        String thTl = str.substring(3, len);
        int lthTl = thTl.length();


        return;
    }

    public static final String[][] chars = new String[][]{{"a", "b"}, {"c", "d", "e"}};

    public static void testStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append(3);
        //stringBuilder.append("Axxc");
        stringBuilder.append('0' + 3);
        String result = stringBuilder.toString();
    }
}
