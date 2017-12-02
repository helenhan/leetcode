package edu.helen.leetcode;

import java.util.*;

public class BinaryTreePreorder {

	public BinaryTreePreorder() {
		// TODO Auto-generated constructor stub
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

	public List<Integer> preorderTraversal3(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root==null){
			return result;
		}
		Stack<TreeNode> stack = new Stack<>();
		while(root!=null||!stack.empty()){
			while(root!=null){
				result.add(root.val);
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			root = root.right;
		}
		return result;
	}

	public static void main(String[] args) {
		BinaryTreePreorder v = new BinaryTreePreorder();
		TreeNode root = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		root.left = two;
		root.right=three;
		two.left = four;
		two.right=five;
		three.right = six;

		List list = v.preorderTraversal3(root);
		System.out.println(Arrays.toString(list.toArray()));

	}


}
