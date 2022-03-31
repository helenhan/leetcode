package com.helen.leetcode;

import java.util.Stack;

/**
 * Created by Helen on 12/11/2017.
 */
public class FlattenBT2LinkedList {
    private TreeNode prev = null;

    public void flatten2(TreeNode root) {
        if (root == null)
            return;
        flatten2(root.right);
        flatten2(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
            if(!stack.isEmpty()){
                node.right = stack.peek();
            }else{
                node.right = null;
            }
            node.left = null;
        }

    }


    public static void main(String[] args) {
        FlattenBT2LinkedList fb = new FlattenBT2LinkedList();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        fb.flatten2(root);
    }
}
