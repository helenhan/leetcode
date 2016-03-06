package edu.helen.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorder {

	public BinaryTreeInorder() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (p != null) {
			while (p != null) {
				if (p.left != null) {
					stack.push(p.left);
				}
				stack.push(p);
				p = p.left;
			}
			p = stack.pop();
			while (!stack.isEmpty() && p.right == null) {
				list.add(p.val);
				p = stack.pop();
			}
			list.add(p.val);
			if (!stack.isEmpty()) {
				stack.pop();
			} else {
				p = null;
			}
		}

		return list;
	}

	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) {
			return list;
		}
		TreeNode node = root;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			if (stack.size() > 0) {
				node = stack.pop();
				list.add(node.val);
				node = node.right;
			}
		}
		return list;
	}
	
	public List<Integer> inorderTraversal3(TreeNode root) {
	    List<Integer> result = new ArrayList<>();
	    Deque<TreeNode> stack = new ArrayDeque<>();
	    TreeNode p = root;
	    while(!stack.isEmpty() || p != null) {
	        if(p != null) {
	            stack.push(p);
	            p = p.left;
	        } else {
	            TreeNode node = stack.pop();
	            result.add(node.val);  // Add after all left children
	            p = node.right;   
	        }
	    }
	    return result;
	}

}
