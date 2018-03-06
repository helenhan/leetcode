package edu.helen.leetcode;

import java.util.Stack;

/**
 * Created by Helen on 2/18/2018.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return helper(root.left,root.right);
    }
    private boolean helper(TreeNode left,TreeNode right){
        if(left==null||right==null){
            return left==right;
        }
        if(left.val!=right.val) return false;
        return helper(left.left,right.right)&&helper(left.right,right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if(root==null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()){
            TreeNode node1 = stack.pop();
            TreeNode node2 = stack.pop();
            if(node1==null&&node2==null) continue;
            if(node1==null||node2==null||node1.val!=node2.val){
                return false;
            }
            stack.push(node1.left);
            stack.push(node2.right);
            stack.push(node1.right);
            stack.push(node2.left);
        }
        return true;
    }
}
