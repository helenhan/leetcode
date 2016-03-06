package edu.helen.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryLevelOrder {

	public BinaryLevelOrder() {
		// TODO Auto-generated constructor stub
	}

	// bfs
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		if (root == null) {
			return list;
		}
		TreeNode p = root;
		int size = 1;
		queue.offer(p);
		while (queue.size() > 0) {
			List<Integer> tmp = new ArrayList<Integer>();
			size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				tmp.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}

			}
			list.add(tmp);

		}

		return list;

	}

	// dfs
	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		dfs(root, list, 0);
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
