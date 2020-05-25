package leetcode.LC_278;

/**
 * 278. First Bad Version
 */
class Solution278 implements VersionControl {
    int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo < hi) {
            final int mid = lo + (hi - lo) / 2;

            if (isBadVersion(mid)) {
                hi = mid;           // Hold `hi` but increment `lo` will make sure `lo` and `hi` meet in the direction towards `hi`.
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    /**
     * Dummy
     */
    @Override
    public boolean isBadVersion(int version) {
        return false;
    }
}

interface VersionControl {
    boolean isBadVersion(int version);
}
