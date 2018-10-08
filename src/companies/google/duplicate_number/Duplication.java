package companies.google.duplicate_number;

/**
 * Created by naco_siren on 9/16/17.
 */
public class Duplication {
    public static void main(String[] args) {
        int[] result1 = duplicateNumber(new int[]{1, 2, 3, 4});
        int[] result2 = duplicateNumber(new int[]{1, 3, 2, 4});
        int[] result3 = duplicateNumber(new int[]{1, 3, 4, 2});
        int[] result4 = duplicateNumber(new int[]{4, 3, 2, 1});
        return;
    }


    public static int[] duplicateNumber(int[] input) {
        /* Handle corner cases */
        int len = 0;
        if (input == null || (len = input.length) == 0)
            return new int[0];
        if (len == 1)
            return new int[]{input[0], input[0]};
        int[] result = new int[len + 1];

        /* Copy all the digits in the first ascending sequence */
        int i = 0, j = 0;
        while (i < len - 1) {
            if (input[i] <= input[i+1]) {
                result[j++] = input[i++];

            } else {
                /* Found the last digit in this ascending sequence */
                result[j++] = input[i];
                while (i < len) {
                    result[j++] = input[i++];
                }
                return result;
            }
        }

        /* The whole sequence is ascending, duplicate the last number */
        result[j] = input[len - 1];
        result[j+1] = input[len - 1];
        return result;
    }
}
