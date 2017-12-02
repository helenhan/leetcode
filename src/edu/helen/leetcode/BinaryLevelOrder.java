package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryLevelOrder {

    public BinaryLevelOrder() {
        // TODO Auto-generated constructor stub
    }

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

    public void dfs(TreeNode node, List<List<Integer>> list, int deep) {
        if (node == null) {
            return;
        }
        if (list.size() == deep) {
            List<Integer> temp = new ArrayList<Integer>();
            list.add(temp);
        }
        list.get(deep).add(node.val);
        dfs(node.left, list, deep + 1);
        dfs(node.right, list, deep + 1);
    }

    public void dfs2(TreeNode node,List<List<Integer>> list, int height){
        if(node==null){
            return;
        }
        if(list.size()==height){
            list.add(new ArrayList<>());
        }
        list.get(height).add(node.val);
        dfs2(node.left,list,height+1);
        dfs2(node.right,list,height+1);
    }



}
