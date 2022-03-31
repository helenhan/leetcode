package com.helen.leetcode;

/**
 * http://fisherlei.blogspot.ca/2012/12/leetcode-next-permutation.html
 * http://bangbingsyb.blogspot.ca/2014/11/leetcode-next-permutation.html
 * O(n)
 * O(1)
 * Created by Helen on 12/9/2017.
 */
public class PermutationNext {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) { //if not found the first number which violate increase trend from left to right, i is -1;
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int low, int high) {
        while (low < high) {
            swap(nums, low, high);
            low++;
            high--;
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;

    }

    public static void main(String[] args) {
        PermutationNext pn = new PermutationNext();
        pn.nextPermutation(new int[] {1,1});
    }
}
