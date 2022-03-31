package com.helen.leetcode;

import java.util.*;

public class BinaryTreePostorder {
    // time exceed
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return list;
        }
        TreeNode p = root;
        TreeNode q = null;
        while (p != null) {
            for (; p.left != null; p = p.left) {
                stack.push(p.left);
            }

            while (p != null && (p.right == null || p.right == q)) {
                list.add(p.val);
                q = p;
                if (stack.isEmpty()) {
                    return list;
                }
                p = stack.pop();
            }
            stack.push(p);
            p = p.right;
        }

        return list;

    }

    //okay
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode node = root, prev = root;
        if (root == null) {
            return list;
        }
        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (stack.size() > 0) {
                TreeNode temp = stack.peek().right;//tmp doesn't have left node, and if these is no right node, process it.
                if (temp == null || temp == prev) { //doesn't have children node or children nodes are processed already.
                    node = stack.pop();
                    list.add(node.val);
                    prev = node;
                    node = null;
                } else {
                    node = temp; //if there are children node, traverse the subtree which root is this node.
                }
            }

        }
        return list;
    }

    public static void main(String[] args) {
        BinaryTreePostorder v = new BinaryTreePostorder();
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        root.left = two;
        root.right = three;
        two.left = four;
        two.right = five;
        three.right = six;

        List list = v.postorderTraversal2(root);
        System.out.println(Arrays.toString(list.toArray()));

    }


}
