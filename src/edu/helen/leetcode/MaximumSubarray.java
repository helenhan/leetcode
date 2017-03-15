package edu.helen.leetcode;

/**
 * Created by Helen on 3/13/2017.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSofar = nums[0];
        int maxEndingHere = nums[0];
        for(int i=1;i<nums.length;++i){
            maxEndingHere = Math.max(maxEndingHere+nums[i],nums[i]);
            maxSofar = Math.max(maxSofar,maxEndingHere);
        }
        return maxSofar;
    }
}
