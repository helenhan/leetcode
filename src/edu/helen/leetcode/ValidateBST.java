package edu.helen.leetcode;

public class ValidateBST {

	public ValidateBST() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isValidBST(TreeNode root) {
		return validBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
	}
	

	public boolean validBST(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}
		
		boolean left = validBST(root.left,min,root.val);
		boolean right = validBST(root.right,root.val,max);
		return ((root.val > min) && (root.val < max)&&left&&right);
	}

}
