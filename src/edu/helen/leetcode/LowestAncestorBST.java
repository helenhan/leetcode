package edu.helen.leetcode;

public class LowestAncestorBST {

	public LowestAncestorBST() {
		// TODO Auto-generated constructor stub
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null){
			return null;
		}
		if(p.val<root.val&&q.val<root.val){
			return lowestCommonAncestor(root.left,p,q);
		}else if(p.val>root.val&&q.val>root.val){
			return lowestCommonAncestor(root.right,p,q);
		}else{
			return root;
		}
	}

	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if(root==null) return null;
		while((root.val-p.val)*(root.val-q.val)>0){
			root = p.val<root.val?root.left:root.right;
		}
		return root;
	}

}
