package java_lang;

import base.TreeNode;

/**
 * Created by naco_siren on 8/18/17.
 */
public class recur {

    public static void main(String[] args) {
        recur r = new recur();
        r.main();

        return;
    }

    public void main(){
        TreeNode node = new TreeNode(1);
        recur(3, node);
        return;
    }

    public void recur(int count, TreeNode root){
        if (count == 0)
            return;
        else {
            root = new TreeNode(root.val * 10);
            recur(count - 1, root);
        }
    }
}
