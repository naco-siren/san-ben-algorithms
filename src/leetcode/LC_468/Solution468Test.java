package leetcode.LC_468;

import org.junit.Test;

import static leetcode.LC_468.Solution468.*;
import static org.junit.Assert.*;

public class Solution468Test {

    @Test
    public void validIPAddress_v4_1() {
        assertEquals(IPV4, new Solution468().validIPAddress("172.16.254.1"));
    }

    @Test
    public void validIPAddress_v4_neither_1() {
        assertEquals(NEITHER, new Solution468().validIPAddress("1.1.1.1."));
    }

    @Test
    public void validIPAddress_v4_neither_2() {
        assertEquals(NEITHER, new Solution468().validIPAddress("01.01.01.01"));
    }

    @Test
    public void validIPAddress_v4_neither_3() {
        assertEquals(NEITHER, new Solution468().validIPAddress("256.256.256.256"));
    }

    @Test
    public void validIPAddress_v6_1() {
        assertEquals(IPV6, new Solution468().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }
    @Test
    public void validIPAddress_v6_neither_1() {
        assertEquals(NEITHER, new Solution468().validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334"));
    }
}