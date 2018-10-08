package companies.google.longest_path;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by naco_siren on 9/16/17.
 */
public class LongestPath {
    public static final String[] IMAGE_EXTENSIONS = new String[]{"jpeg", "png", "gif"};

    public static void main(String[] args) {
        String input1 = "dir\nddir\n a.txt\n b.jpeg\n c.gif\nddir2\n dddir\nddddir\n aaa.exe";
        LongestPath longestPath = new LongestPath(input1, IMAGE_EXTENSIONS);
        String maxAbsPath = longestPath.longestPath();

        return;
    }

    private TreeNode _root;
    private HashSet<String> _imgExts;
    public LongestPath(String input, String[] imgExts){
        /* Cache all the target image extensions for quicker indexing */
        _imgExts = new HashSet<>(imgExts.length);
        for (String ext : imgExts) _imgExts.add(ext);

        /* Build the file system tree */
        parsePaths(input);
    }

    public void parsePaths(String str) {
        if (str == null || str.length() == 0) return;
        String inputs[] = str.split("\n");

        TreeNode root = new TreeNode("", -1, true, null);
        TreeNode curNode = root;
        for (String input : inputs) {
            /* Count the blank spaces at the beginning of current line (record) */
            int j = 0;
            while (input.charAt(j) == ' ') j++;

            /* Instantiate a TreeNode to save current line */
            String val = input.trim();
            boolean isDir = val.indexOf('.') == -1 ? true : false;
            TreeNode temp = new TreeNode(val, j, isDir, curNode);

            /* Don't append if file is not directory,
               or has an irrelevant extension name  */
            boolean shouldAppend = false;
            if (isDir == true) {
                shouldAppend = true;
            } else {
                String ext = val.split("\\.")[1];
                if (_imgExts.contains(ext))
                    shouldAppend = true;
            }
            if (shouldAppend == false) continue;

            /* Append it to the correct previous */
            if (j == curNode.depth + 1) {
                curNode.children.add(temp);
            } else {
                while (j != curNode.depth + 1)
                    curNode = curNode.previous;
                curNode.children.add(temp);
            }
            curNode = temp;
        }
        _root = root;
    }


    private int maxLen = 0;
    private String maxAbsPath = null;

    /**
     * Find the longest absolute path in the tree
     * @return
     */
    public String longestPath() {
        helper(_root, "");

        return maxAbsPath;
    }

    public void helper(TreeNode root, String path){
        if (root.isDir == false) {
            /* Update the record if current node is file */
            String absPath = path + root.val;
            int curLen = absPath.length();
            if (curLen > maxLen) {
                maxLen = curLen;
                maxAbsPath = absPath;
                System.out.println(absPath);
            }


        } else {
            /* Continue DFS if current node is directory */
            for (TreeNode child : root.children)
                helper(child, path + root.val + "/");
        }
    }


    /**
     * Tree node with depth and reference to previously visited node
     */
    class TreeNode{
        String val;
        int depth;
        boolean isDir;

        TreeNode previous;
        LinkedList<TreeNode> children;

        public TreeNode(String val, int depth, boolean isDir, TreeNode previous) {
            this.val = val;
            this.depth = depth;
            this.isDir = isDir;
            this.previous = previous;
            this.children = new LinkedList<>();
        }

        @Override
        public String toString() {
            return val + ", " + children.size() + " children";
        }
    }

}
