package com.helen.leetcode;

/**
 * Created by Helen on 2/28/2018.
 */
public class MaximumBT {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left>right) {
            return null;
        }
        int index = left;
        for (int i = left; i <= right; i++) {
            if (nums[index] < nums[i]) {
                index = i;
            }
        }

        TreeNode root = new TreeNode(nums[index]);
        root.left = helper(nums, left, index - 1);
        root.right = helper(nums, index + 1, right);
        return root;
    }
}
