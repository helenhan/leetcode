package edu.helen.leetcode;

/**
 * Created by Helen on 11/9/2017.
 */
public class BSTGreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root!=null){
            convertBST(root.right);
            sum+= root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
