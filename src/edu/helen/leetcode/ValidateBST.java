package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    public boolean isValidBST2(TreeNode root) {
        return validBST2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    public boolean validBST2(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        boolean left = validBST2(root.left, min, root.val);
        boolean right = validBST2(root.right, root.val, max);
        return ((root.val > min) && (root.val < max) && left && right);
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }

    public static void main(String[] args) {
        ValidateBST v = new ValidateBST();
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

        List list = v.inorderTraversal(root);
        System.out.println(Arrays.toString(list.toArray()));

    }
}
