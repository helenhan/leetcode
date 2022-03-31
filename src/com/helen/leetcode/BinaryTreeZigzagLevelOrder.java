package com.helen.leetcode;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrder {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		helper(root, list, 0);
		return list;

	}

	public void helper(TreeNode p, List<List<Integer>> list, int deep) {
		if (p == null) {
			return;
		}
		List<Integer> temp = null;
		if (list.size() == deep) {
			temp = new LinkedList<Integer>();
			list.add(temp);
		}
		if ((deep % 2) == 0) {
			list.get(deep).add(p.val);
		}else{
			((LinkedList)list.get(deep)).addFirst(p.val);
		}
		
		helper(p.left,list,deep+1);
		helper(p.right,list,deep+1);
	}
}
