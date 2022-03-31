package com.helen.leetcode;

/**
 * Created by Helen on 2/7/2018.
 */
public class MiniSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int from = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                min = Math.min(min, i - from + 1);
                sum -= nums[from++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
