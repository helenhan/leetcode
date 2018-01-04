package edu.helen.leetcode;

/**
 * https://discuss.leetcode.com/topic/6413/dp-solution-some-thoughts
 * <p>
 * Created by Helen on 3/13/2017.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSofar = nums[0];
        int maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSofar = Math.max(maxSofar, maxEndingHere);
        }
        return maxSofar;
    }

    //dp
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length]; //dp[i] means the maximum subarray ending with A[i];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;

    }

    public static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        ms.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
}
