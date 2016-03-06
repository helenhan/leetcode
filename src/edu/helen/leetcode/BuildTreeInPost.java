package edu.helen.leetcode;

public class BuildTreeInPost {

	public BuildTreeInPost() {
		// TODO Auto-generated constructor stub
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0||inorder.length==0) return null;
        TreeNode root = helper(inorder, postorder, postorder.length-1, 0,postorder.length-1 );
        return root;

    }

    private TreeNode helper(int[] inorder, int[] postorder,int rootIdx, int start, int end){
        if (start > end||start<0||end>=inorder.length) return null;
        TreeNode root = new TreeNode(postorder[rootIdx]);
        int index = findIdx(inorder,start,end, root.val);
        int leftSize = end-index ;
        root.left = helper(inorder,postorder,rootIdx-1-leftSize,start,index-1);
        root.right = helper(inorder,postorder,rootIdx-1,index+1,end);
        return root;
    }

    private int findIdx(int[] inorder, int start, int end, int key) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == key) return i;
        }
        return -1;
    }    


}
