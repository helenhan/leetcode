package edu.helen.leetcode;

public class SortedArray2BST {

	public SortedArray2BST() {
		// TODO Auto-generated constructor stub
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length==0){
			return null;
		}
		return build(nums,0,nums.length-1);
	}
	
	public TreeNode build(int[] nums,int start, int end){
		if(start>end){
			return null;
		}
		int index = (start+end)/2;
		int rootVal = nums[index];
		TreeNode root = new TreeNode(rootVal);
		root.left = build(nums,start,index-1);
		root.right = build(nums,index+1,end);
		return root;
	}

}
