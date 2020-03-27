package leetcode.LC_729;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyCalendarTest {

    @Test
    public void book_0() {
        MyCalendar myCalendar = new MyCalendar();
        assertTrue(myCalendar.book(10, 20));
        assertFalse(myCalendar.book(15, 25));
        assertTrue(myCalendar.book(20, 30));
        assertTrue(myCalendar.book(40, 50));
        assertFalse(myCalendar.book(29, 40));
        assertTrue(myCalendar.book(30, 40));
    }
}