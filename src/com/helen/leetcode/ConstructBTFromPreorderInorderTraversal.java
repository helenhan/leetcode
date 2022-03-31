package com.helen.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * The basic idea is here:
 Say we have 2 arrays, PRE and IN.
 Preorder traversing implies that PRE[0] is the root node.
 Then we can find this PRE[0] in IN, say it’s IN[5].
 Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
 Recursively doing this on subarrays, we can build a tree out of it :)

 *  https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34538/My-Accepted-Java-Solution
 * Created by Helen on 2/18/2018.
 */
public class ConstructBTFromPreorderInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||preorder.length==0||inorder.length==0){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
    private TreeNode helper(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart, int inEnd,Map<Integer,Integer> map){
        if(preEnd<preStart||inEnd<inStart){
            return null;
        }
        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        int index = map.get(val);
        int numLeft = index-inStart;

        root.left = helper(preorder,preStart+1,preStart+numLeft,inorder,inStart,index-1,map);
        root.right = helper(preorder,preStart+numLeft+1,preEnd,inorder,index+1,inEnd,map);
        return root;

    }
}
