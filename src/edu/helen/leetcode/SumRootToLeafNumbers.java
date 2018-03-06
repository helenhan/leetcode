package edu.helen.leetcode;

/**
 * Created by Helen on 2/22/2018.
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, 0);
    }

    private int helper(TreeNode root, int n) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 10 * n + root.val;
        }
        return helper(root.left, 10 * n + root.val) + helper(root.right, 10 * n + root.val);
    }

    public static void main(String[] args) {
        SumRootToLeafNumbers sr = new SumRootToLeafNumbers();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        sr.sumNumbers(root);
    }
}
