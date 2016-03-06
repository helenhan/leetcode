package edu.helen.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorder {

	public BinaryTreePostorder() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// time exceed
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) {
			return list;
		}
		TreeNode p = root;
		TreeNode q = null;
		while (p != null) {
			for (; p.left != null; p = p.left) {
				stack.push(p.left);
			}

			while (p != null && (p.right == null || p.right == q)) {
				list.add(p.val);
				q = p;
				if (stack.isEmpty()) {
					return list;
				}
				p = stack.pop();
			}
			stack.push(p);
			p = p.right;
		}

		return list;

	}

	//okay
	public List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		// Deque<TreeNode> rstack = new ArrayDeque<TreeNode>();
		TreeNode node = root, prev = root;
		if (root == null) {
			return list;
		}
		while (node != null || stack.size() > 0) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			if (stack.size() > 0) {
				TreeNode temp = stack.peek().right;
				if (temp == null || temp == prev) {
					node = stack.pop();
					list.add(node.val);
					prev = node;
					node = null;
				} else {
					node = temp;
				}
			}

		}
		return list;
	}

}
