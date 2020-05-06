package leetcode.LC_071;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution71Test {

    @Test
    public void simplifyPath_1() {
        assertEquals("/home", new Solution71().simplifyPath("/home/"));
    }

    @Test
    public void simplifyPath_2() {
        assertEquals("/", new Solution71().simplifyPath("/../"));
    }

    @Test
    public void simplifyPath_3() {
        assertEquals("/home/foo", new Solution71().simplifyPath("/home//foo/"));
    }

    @Test
    public void simplifyPath_4() {
        assertEquals("/c", new Solution71().simplifyPath("/a/./b/../../c/"));
    }

    @Test
    public void simplifyPath_5() {
        assertEquals("/c", new Solution71().simplifyPath("/a/../../b/../c//.//"));
    }

    @Test
    public void simplifyPath_6() {
        assertEquals("/a/b/c", new Solution71().simplifyPath("/a//b////c/d//././/.."));
    }
}