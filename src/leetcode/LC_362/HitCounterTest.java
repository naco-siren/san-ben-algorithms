package leetcode.LC_362;

import org.junit.Test;

import static org.junit.Assert.*;

public class HitCounterTest {

    @Test
    public void getHit_0() {
        HitCounter counter = new HitCounter();

        // hit at timestamp 1.
        counter.hit(1);

        // hit at timestamp 2.
        counter.hit(2);

        // hit at timestamp 3.
        counter.hit(3);

        // get hits at timestamp 4, should return 3.
        assertEquals(3, counter.getHits(4));

        // hit at timestamp 300.
        counter.hit(300);

        // get hits at timestamp 300, should return 4.
        assertEquals(4, counter.getHits(300));

        // get hits at timestamp 301, should return 3.
        assertEquals(3, counter.getHits(301));
    }

    @Test
    public void getHits_1() {
        HitCounter counter = new HitCounter();

        // 3 hits at timestamp 1.
        counter.hit(1);
        counter.hit(1);
        counter.hit(1);

        // hit at timestamp 300.
        counter.hit(300);

        // get hits at timestamp 300, should return 4.
        assertEquals(4, counter.getHits(300));
    }

    @Test
    public void getHits_2() {
        HitCounter counter = new HitCounter();

        // 3 hits at timestamp 1.
        counter.hit(1);
        counter.hit(1);
        counter.hit(1);

        // hit at timestamp 300.
        counter.hit(300);

        // get hits at timestamp 300, should return 4.
        assertEquals(4, counter.getHits(300));

        // hit at timestamp 300.
        counter.hit(300);

        // get hits at timestamp 300, should return 5.
        assertEquals(5, counter.getHits(300));
    }
}