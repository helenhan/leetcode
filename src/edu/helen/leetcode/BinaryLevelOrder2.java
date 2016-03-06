package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryLevelOrder2 {

	public BinaryLevelOrder2() {
		// TODO Auto-generated constructor stub
	}

	// dfs
		public List<List<Integer>> levelOrder(TreeNode root) {
			List<List<Integer>> list = new ArrayList<List<Integer>>();
			dfs(root, list, 0);
			Collections.reverse(list);
			return list;

		}

		public void dfs(TreeNode node, List<List<Integer>> list, int deep) {
			if (node == null) {
				return;
			}
			if (list.size() == deep) {
				List<Integer> temp = new ArrayList<Integer>();
				list.add(temp);
			}
			list.get(deep).add(node.val);
			dfs(node.left,list,deep+1);
			dfs(node.right,list,deep+1);
		}

}
