package leetcode.LC_274;

public class Solution {
    public static void main(String[] args) {
        int r1 = hIndex(new int[]{3, 0, 6, 1, 5});  // 3
    }

    public static int hIndex(int[] citations) {
        int n = citations.length;
        int[] histogram = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                histogram[n]++;
            } else {
                histogram[citations[i]]++;
            }
        }

        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += histogram[i];
            if (sum >= i)
                return i;
        }
        return -1;
    }

}
