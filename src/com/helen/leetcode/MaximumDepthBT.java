package com.helen.leetcode;

public class MaximumDepthBT {

	public MaximumDepthBT() {
		// TODO Auto-generated constructor stub
	}

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left, right) + 1;
	}

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if(root.left!=null&&root.right!=null){
			return Math.min(minDepth(root.left), minDepth(root.right))+1;
		}else{ //if one child node is null, just need to calculate depth of the other side sub tree
			return Math.max(minDepth(root.left), minDepth(root.right))+1;
		}
	}

}
