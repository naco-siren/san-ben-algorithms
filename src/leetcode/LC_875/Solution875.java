package leetcode.LC_875;

/**
 * 875. Koko Eating Bananas
 */
class Solution875 {
    int minEatingSpeed(int[] piles, int H) {
        // Calculate total bananas
        int sum = 0;
        for (int pile : piles)
            sum += pile;

        int minHours = sum;

        // Perform binary search
        int lo = 1, hi = 1_000_000_000;
        while (lo < hi) {
            final int mid = (lo + hi) / 2;

            if (canFinishInH(piles, mid, H)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean canFinishInH(final int[] piles, final int speed, final int H) {
        int hours = 0;
        for (int pile : piles) {
            // int hour = pile / speed;
            // hours += hour;
            // if (pile % speed > 0)
            //     hours++;

            // THIS APPROACH IS BETTER!
            hours += (pile - 1) / speed + 1;
        }
        return hours <= H;
    }
}
