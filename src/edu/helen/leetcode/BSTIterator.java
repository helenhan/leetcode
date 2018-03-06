package edu.helen.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/discuss/52525/My-solutions-in-3-languages-with-Stack
 *
 * I use Stack to store directed left children from root.
 When next() is called, I just pop one element and process its right child as new root.
 The code is pretty straightforward.

 So this can satisfy O(h) memory, hasNext() in O(1) time,
 But next() is O(h) time.

 I can’t find a solution that can satisfy both next() in O(1) time, space in O(h).

 answer:
 The average time complexity of next() function is O(1) indeed in your case. As the next function can be called n times at most,
 and the number of right nodes in self.pushAll(tmpNode.right) function is maximal n in a tree which has n nodes, so the amortized time complexity is O(1).

 */
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
