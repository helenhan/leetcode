package edu.helen.leetcode;

public class BuildTreePreOrderInOrder {

	public BuildTreePreOrderInOrder() {
		// TODO Auto-generated constructor stub
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null) {
			return null;
		}
		return build(preorder, inorder, 0, preorder.length, 0,
				inorder.length);
	}

	public TreeNode build(int[] preorder, int[] inorder, int preStart,
			int preend, int instart, int inend) {
		if (preStart == preend) {
	        return null;
	    }
		int rootval = preorder[preStart];
		int inroot = -1;
		for (int i = instart, j = inend - 1; i <= j; ++i, --j) {
			if (inorder[i] == rootval) {
				inroot = i;
				break;
			} else if (inorder[j] == rootval) {
				inroot = j;
				break;
			}
		}
		if (inroot == -1) {
			throw new IllegalArgumentException("Only in preorder: " + rootval);
		}
		TreeNode root = new TreeNode(rootval);
		root.left = build(preorder, inorder, preStart + 1, preStart + 1
				+ (inroot - instart), instart, inroot);
		root.right = build(preorder, inorder,
				preStart + 1 + (inroot - instart), preend, inroot + 1, inend);
		return root;
	}

}
