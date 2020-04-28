package leetcode.LC_FirstUniqueNumber;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstUniqueTest {

    @Test
    public void showFirstUnique_0() {
        FirstUnique firstUnique = new FirstUnique(new int[]{2,3,5});
        assertEquals(2, firstUnique.showFirstUnique());
        firstUnique.add(5);            // the queue is now [2,3,5,5]
        assertEquals(2, firstUnique.showFirstUnique()); // return 2
        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
        assertEquals(3, firstUnique.showFirstUnique()); // return 3
        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
        assertEquals(-1, firstUnique.showFirstUnique()); // return -1
    }


    @Test
    public void showFirstUnique_1() {
        FirstUnique firstUnique = new FirstUnique(new int[]{7,7,7,7,7,7});
        assertEquals(-1, firstUnique.showFirstUnique()); // return -1
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
        firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
        assertEquals(17, firstUnique.showFirstUnique()); // return 17
    }

    @Test
    public void showFirstUnique_2() {
        FirstUnique firstUnique = new FirstUnique(new int[]{809});
        assertEquals(809, firstUnique.showFirstUnique()); // return 809
        firstUnique.add(809);          // the queue is now [809,809]
        assertEquals(-1, firstUnique.showFirstUnique()); // return -1
    }
}