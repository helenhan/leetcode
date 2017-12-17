package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightView {

    public BinaryTreeRightView() {
        // TODO Auto-generated constructor stub
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(root);
        while (!queue.isEmpty()) {//Level by level BFS
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (i == count - 1) // The right-most node of the current level
                    res.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return res;
    }


    // dfs
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(root, list, 0);
        return list;

    }

    public void helper(TreeNode p, List<Integer> list, int deep) {
        if (p == null) {
            return;
        }
        if (list.size() == deep) {
            list.add(p.val);
        }
        helper(p.right, list, deep + 1); //notice process node from right to left.
        helper(p.left, list, deep + 1);
    }

}
