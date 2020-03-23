package leetcode.LC_222;

import base.TreeNode;
import org.junit.Test;

import static leetcode.LC_222.Solution.countNodes;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void countNodes_1() {
        TreeNode r1 = new TreeNode(1);
        assertEquals(1, countNodes(r1));
    }


    @Test
    public void countNodes_2() {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);  r1.left = r2;
        assertEquals(2, countNodes(r1));
    }

    @Test
    public void countNodes_3() {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);  r1.left = r2;
        TreeNode r3 = new TreeNode(3);  r1.right = r3;
        assertEquals(3, countNodes(r1));
    }

    @Test
    public void countNodes_4() {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);  r1.left = r2;
        TreeNode r3 = new TreeNode(3);  r1.right = r3;
        TreeNode r4 = new TreeNode(4);  r2.left = r4;
        assertEquals(4, countNodes(r1));
    }

    @Test
    public void countNodes_5() {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);  r1.left = r2;
        TreeNode r3 = new TreeNode(3);  r1.right = r3;
        TreeNode r4 = new TreeNode(4);  r2.left = r4;
        TreeNode r5 = new TreeNode(5);  r2.right = r5;
        assertEquals(5, countNodes(r1));
    }

    @Test
    public void countNodes_6() {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);  r1.left = r2;
        TreeNode r3 = new TreeNode(3);  r1.right = r3;
        TreeNode r4 = new TreeNode(4);  r2.left = r4;
        TreeNode r5 = new TreeNode(5);  r2.right = r5;
        TreeNode r6 = new TreeNode(6);  r3.left = r6;
        assertEquals(6, countNodes(r1));
    }

    @Test
    public void countNodes_7() {
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);  r1.left = r2;
        TreeNode r3 = new TreeNode(3);  r1.right = r3;
        TreeNode r4 = new TreeNode(4);  r2.left = r4;
        TreeNode r5 = new TreeNode(5);  r2.right = r5;
        TreeNode r6 = new TreeNode(6);  r3.left = r6;
        TreeNode r7 = new TreeNode(6);  r3.right = r7;
        assertEquals(7, countNodes(r1));
    }
}