package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://discuss.leetcode.com/topic/100145/java-c-very-simple-dfs-solution/7
 * Created by Helen on 11/24/2017.
 */
public class MaximumWidthBT {
    int max =1;
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        List<Integer> list = new ArrayList<>();
        help(root,0,1,list);
        return max;
    }

    public void help(TreeNode root,int level,int index,List<Integer> list){
        if(root==null) return;
        if(list.size()==level){
            list.add(index);
        }
        max = Math.max(max,index-list.get(level)+1);
        help(root.left,level+1,2*index,list);
        help(root.right,level+1,2*index+1,list);
    }
}
