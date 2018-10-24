package companies.uber.coverage;

// Create a new object called Coverage
// Coverage stores a list of ranges (aka intervals) for integer values
// ranges are inclusive
// Within a single instance of a Coverage, the ranges within must not overlap (uses fewest number of ranges possible)
// implement 2 methods for this class.
// 1) addRange(int start, int end) : add range will add the specified range, and resolve any overlapping issues
// 2) toString() : print Coverage contents for debugging

public class Coverage {
    public static void main(String[] args) {
         Coverage c = new Coverage();
         c.addRange(0,10);
         c.addRange(20,30);
         String r1 = c.toString();      // [(0,10),(20,30)]
         c.addRange(5,25);
         String r2 = c.toString();      // [(0,30)]
    }

    Coverage() {

    }

    void addRange(int start, int end) {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
