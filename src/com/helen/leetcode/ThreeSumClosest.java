package com.helen.leetcode;

import java.util.Arrays;

/**
 * Similar to 3 Sum problem, use 3 pointers to point current element, next element and the last element.
 * If the sum is less than target, it means we have to add a larger element so next element move to the next.
 * If the sum is greater, it means we have to add a smaller element so last element move to the second last element.
 * Keep doing this until the end. Each time compare the difference between sum and target, if it is less than minimum difference so far,
 * then replace result with it, otherwise keep iterating.
 *
 * time complexity O(n^2)
 * space complexity O(1)
 * Created by Helen on 9/19/2017.
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int start = i + 1, end = nums.length - 1;
                while (start < end) {
                    int sum = nums[start] + nums[i] + nums[end];
                    if (sum > target) {
                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        end--;
                    } else if (sum < target) {
                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        start++;
                    } else {
                        return sum;
                    }
                    if (Math.abs(sum - target) < Math.abs(result - target)) {
                        result = sum;
                    }
                }
            }
        }

        return result;
    }
}
