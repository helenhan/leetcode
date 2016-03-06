package edu.helen.leetcode;

public class InvertBinaryTree {

	public InvertBinaryTree() {
		// TODO Auto-generated constructor stub
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}

}
