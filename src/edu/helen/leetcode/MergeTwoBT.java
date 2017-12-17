package edu.helen.leetcode;

/**
 * Created by Helen on 11/22/2017.
 */
public class MergeTwoBT {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        int value = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newNode = new TreeNode(value);
        newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left); // remember to check null for both left and right nodes.
        newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return newNode;
    }
}
