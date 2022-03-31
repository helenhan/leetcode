package com.helen.leetcode;

import java.util.*;

public class BinaryTreePath {

    public BinaryTreePath() {
        // TODO Auto-generated constructor stub
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        //exit
        if (root == null) {
            return res;
        }
        //leaf
        if (root.right == null && root.left == null) {
            res.add("" + root.val);
            return res;
        }
        //divide
        List<String> leftlist = binaryTreePaths(root.left);
        List<String> rightlist = binaryTreePaths(root.right);

        //merge
        for (String str : leftlist) {
            res.add(root.val + "->" + str);
        }
        for (String str : rightlist) {
            res.add(root.val + "->" + str);
        }
        return res;
    }

    public List<String> binaryTreePaths2(TreeNode root) {
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
            for (Iterator<TreeNode> ite = nodes.descendingIterator(); ite.hasNext(); ) {
                s.append(ite.next().val);
                s.append("->");
            }
            s.append(p.val);
            paths.add(s.toString());
            return;
        }
        nodes.push(p);
        helper(p.left, paths, nodes);
        helper(p.right, paths, nodes);
        nodes.pop();
    }


}
