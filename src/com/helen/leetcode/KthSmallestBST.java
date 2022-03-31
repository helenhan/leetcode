package com.helen.leetcode;

import java.util.*;

public class KthSmallestBST {

    public KthSmallestBST() {
        // TODO Auto-generated constructor stub
    }

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        List<TreeNode> result = new LinkedList<TreeNode>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode p = root;
        int smallest = Integer.MIN_VALUE;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode temp = stack.pop();
                result.add(temp);
                if (result.size() == k) {
                    smallest = temp.val;
                    break;
                }
                p = temp.right;
            }
        }
        return smallest;
    }

    int kthSmallestVal;
    int n = 1;

    public int kthSmallest2(TreeNode root, int k) {

        // in-order traversal
        traversal(root, k);
        return kthSmallestVal;

    }

    public void traversal(TreeNode root, int k) {
        if (root == null)
            return;
        traversal(root.left, k);
        if (n++ == k) {
            kthSmallestVal = root.val;
            return;
        }
        traversal(root.right, k);
        return;
    }

    //inorder iterative
    public int kthSmallest3(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }

}
