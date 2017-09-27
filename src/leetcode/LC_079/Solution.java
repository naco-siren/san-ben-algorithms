package leetcode.LC_079;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by naco_siren on 9/26/17.
 */
public class Solution {
    public static void main(String[] args) {

        String s1 = simplifyPath("/..");
        String s2 = simplifyPath("/a/./b/../../c/cd/");

        return;
    }

    public static String simplifyPath(String path) {
        if(path == null)
            return null;

        String[] dirs = path.split("/+");

        String[] results = new String[dirs.length];
        int ptr = 0;

        for(String dir : dirs){
            if(dir.equals("..")){
                if(ptr > 0)
                    ptr--;
            } else if(dir.equals(".") || dir.length() == 0){
                continue;
            } else {
                results[ptr++] = dir;
            }
        }

        if(ptr == 0)
            return "/";
        else {
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < ptr; i++){
                builder.append("/" + results[i]);
            }
            return builder.toString();
        }


    }
}