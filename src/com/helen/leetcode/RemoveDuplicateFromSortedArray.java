package com.helen.leetcode;

/**
 * Created by Helen on 2/21/2018.
 */
public class RemoveDuplicateFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicateFromSortedArray rd = new RemoveDuplicateFromSortedArray();
        rd.removeDuplicates(new int[]{1,1,2});
    }
}
