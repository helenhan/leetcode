package edu.helen.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorder {

	public BinaryTreePreorder() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root==null){
			return list;
		}
		TreeNode p = root;
		stack.push(p);
		while(!stack.isEmpty()){
			p = stack.pop();
			list.add(p.val);
			if(p.right!=null){
				stack.push(p.right);
			}
			
			if(p.left!=null){
				stack.push(p.left);
			}
			
		}
		return list;
				
	}
	
	public List<Integer> preorderTraversal2(TreeNode root) {
	    List<Integer> result = new ArrayList<>();
	    Deque<TreeNode> stack = new ArrayDeque<>();
	    TreeNode p = root;
	    while(!stack.isEmpty() || p != null) {
	        if(p != null) {
	            stack.push(p);
	            result.add(p.val);  // Add before going to children
	            p = p.left;
	        } else {
	            TreeNode node = stack.pop();
	            p = node.right;   
	        }
	    }
	    return result;
	}

}
