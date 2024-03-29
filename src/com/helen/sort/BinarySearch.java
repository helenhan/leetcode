package com.helen.sort;

/**
 * Created by Helen on 10/28/2017.
 */
public class BinarySearch {
    public boolean binarySearch(int[] nums, int target){
       int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int middle = low+(high-low)/2;
            if(nums[middle]==target){
                return true;
            }else if(nums[middle]<target){
                low = middle+1;
            }else {
                high = middle -1;
            }
        }
        return false;
    }

}
