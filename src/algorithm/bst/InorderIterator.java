package algorithm.bst;

import base.TreeNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by naco_siren on 10/17/17.
 */
public class InorderIterator implements Iterator<Integer> {
    public static void main(String[] args) {
        TreeNode n11 = new TreeNode(5);

        TreeNode n21 = new TreeNode(3); TreeNode n22 = new TreeNode(7);
        n11.left = n21; n11.right = n22;

        TreeNode n31 = new TreeNode(2); TreeNode n32 = new TreeNode(4); TreeNode n33 = new TreeNode(6); TreeNode n34 = new TreeNode(8);
        n21.left = n31; n21.right = n32; n22.left = n33; n22.right = n34;

        InorderIterator iter1 = new InorderIterator(n11);
        LinkedList<Integer> r1 = new LinkedList<>();
        while (iter1.hasNext())
            r1.offer(iter1.next());
        // [2, 3, 4, 5, 6, 7, 8]

        return;
    }


    TreeNode _root;
    Stack<TreeNode> _stk;
    public InorderIterator(TreeNode root) {
        this._root = root;
        this._stk = new Stack();
    }


    @Override
    public boolean hasNext() {
        if (_root == null && _stk.isEmpty())
            return false;
        else
            return true;
    }

    @Override
    public Integer next() {
        while (_root != null || !_stk.isEmpty()) {
            if (_root != null) {
                _stk.push(_root);
                _root = _root.left;

            } else {
                TreeNode node = _stk.pop();
                _root = node.right;
                return node.val;
            }
        }
        return null;
    }
}
