package edu.helen.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class BinaryTreePath {

	public BinaryTreePath() {
		// TODO Auto-generated constructor stub
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<String>();
		Deque<TreeNode> nodes = new ArrayDeque<TreeNode>();
		helper(root, paths, nodes);
		return paths;

	}

	public void helper(TreeNode p, List<String> paths, Deque<TreeNode> nodes) {
		if (p == null) {
			return;
		}
		if (p.left == null && p.right == null) {
			StringBuffer s = new StringBuffer();
			for(Iterator<TreeNode> ite = nodes.descendingIterator();ite.hasNext();) {
				s.append(ite.next().val);
				s.append("->");
			}
			s.append(p.val);
			paths.add(s.toString());
			return;
		}
		nodes.push(p);
		helper(p.left,paths,nodes);
		helper(p.right,paths,nodes);
		nodes.pop();
	}
}
