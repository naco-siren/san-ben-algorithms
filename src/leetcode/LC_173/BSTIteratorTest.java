package leetcode.LC_173;

import org.junit.Test;

import static org.junit.Assert.*;

public class BSTIteratorTest {

    @Test
    public void case_1() {
        /**
         *      7
         *    /  \
         *   3   15
         *      / \
         *     9  20
         */

        BSTIterator.TreeNode n33 = new BSTIterator.TreeNode(9);
        BSTIterator.TreeNode n34 = new BSTIterator.TreeNode(20);
        BSTIterator.TreeNode n21 = new BSTIterator.TreeNode(3);
        BSTIterator.TreeNode n22 = new BSTIterator.TreeNode(15, n33, n34);
        BSTIterator.TreeNode n11 = new BSTIterator.TreeNode(7, n21, n22);

        BSTIterator iterator = new BSTIterator(n11);
        iterator.next();    // return 3
        iterator.next();    // return 7
        iterator.hasNext(); // return true
        iterator.next();    // return 9
        iterator.hasNext(); // return true
        iterator.next();    // return 15
        iterator.hasNext(); // return true
        iterator.next();    // return 20
        iterator.hasNext(); // return false
    }
}