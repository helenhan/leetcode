package edu.helen.leetcode;

/**
 * Created by Helen on 11/9/2017.
 */
public class BSTGreaterTree {
    int sum = 0; //sum is global variable
    public TreeNode convertBST(TreeNode root) {
        if(root!=null){
            convertBST(root.right); //right node greater than root, so it should be from right. right doesn't need to change.
                                    // We get sum of right sub tree here
            sum+= root.val; // root needs add sum of right sub tree
            root.val = sum;
            convertBST(root.left); // left need to add sum of right subtree and root value. After convert, the most left node has greatest value, is final sum.
        }
        return root;
    }


}
