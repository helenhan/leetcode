package edu.helen.leetcode;

public class LowestAncestorBT {

	public LowestAncestorBT() {
		// TODO Auto-generated constructor stub
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null||root==p||root==q){
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left,p,q);
		TreeNode right = lowestCommonAncestor(root.right,p,q);
		if(left!=null&&right!=null){
			return root;
		}else{
			return left!=null? left:right;
		}
	}

}
