package edu.helen.leetcode;

import java.util.Arrays;

/**
 * http://www.cnblogs.com/grandyang/p/4938187.html
 * 首先来看一种动态规划Dynamic Programming的解法，这种解法的时间复杂度为O(n2)，类似brute force的解法，
 * 我们维护一个一维dp数组，其中dp[i]表示以nums[i]为结尾的最长递增子串的长度，对于每一个nums[i]，我们从第一个数再搜索到i，如果发现某个数小于nums[i]，
 * 我们更新dp[i]，更新方法为dp[i] = max(dp[i], dp[j] + 1)，即比较当前dp[i]的值和那个小于num[i]的数的dp值加1的大小，
 * 我们就这样不断的更新dp数组，到最后dp数组中最大的值就是我们要返回的LIS的长度.
 * <p>
 * Created by Helen on 1/7/2018.
 */
public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    //https://leetcode.com/problems/longest-increasing-subsequence/solution/
    // not understand totally
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num); //Arrays.binarySearch() method returns index of the search key,
            // if it is contained in the array, else it returns (-(insertion point) - 1). The insertion point is the point at which the key would be inserted into the array:
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence ls = new LongestIncreasingSubsequence();
        System.out.println(ls.lengthOfLIS2(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
