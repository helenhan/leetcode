package edu.helen.leetcode;

import java.util.*;

public class BinaryTreeInorder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (p != null) {
            while (p != null) {
                if (p.left != null) {
                    stack.push(p.left);
                }
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            while (!stack.isEmpty() && p.right == null) {
                list.add(p.val);
                p = stack.pop();
            }
            list.add(p.val);
            if (!stack.isEmpty()) {
                stack.pop();
            } else {
                p = null;
            }
        }

        return list;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);  // Add after all left children
                p = node.right;
            }
        }
        return result;
    }

}
