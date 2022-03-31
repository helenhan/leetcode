package com.helen.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryLevelOrder {

    // bfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> tmpList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                tmpList.add(queue.poll().val);
            }
            res.add(tmpList);
        }
        return res;

    }

    // dfs
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        dfs(root, list, 0);
        return list;

    }

    public void dfs(TreeNode node, List<List<Integer>> list, int height) {
        if (node == null) {
            return;
        }
        if (list.size() == height) { //it says we could do next level, last level is done.
            list.add(new ArrayList<>());
        }
        list.get(height).add(node.val);
        dfs(node.left, list, height + 1);
        dfs(node.right, list, height + 1);
    }

}
