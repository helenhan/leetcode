package com.helen.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/discuss/77778/Java-O(n)-explain-how-I-come-up-with-this-idea
 * <p>
 * The subarray sum reminds me the range sum problem. Preprocess the input array such that you get
 * the range sum in constant time.
 * sum[i] means the sum from 0 to i inclusively
 * the sum from i to j is sum[j] - sum[i - 1] except that from 0 to j is sum[j].
 * j-i is equal to the length of subarray of original array. we want to find the max(j - i)
 * for any sum[j] we need to find if there is a previous sum[i] such that sum[j] - sum[i] = k
 * Instead of scanning from 0 to j -1 to find such i, we use hashmap to do the job in constant time.
 * However, there might be duplicate value of of sum[i] we should avoid overriding its index as we want the max j - i, so we want to keep i as left as possible.
 * <p>
 * Created by Helen on 2/12/2018.
 */
public class MaximumSizeSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum == k) {
                max = i + 1;
            } else if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return max;
    }
}
