package edu.helen.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {

	Deque<TreeNode> q = new ArrayDeque<TreeNode>();

	public BSTIterator(TreeNode root) {
		helper(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !q.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode node = q.pop();
		helper(node.right);//the right node is the smallest number now, push it in stack
		return node.val;
	}

	public void helper(TreeNode p) {
		while (p != null) {
			q.push(p);
			p = p.left;
		}

	}

}
