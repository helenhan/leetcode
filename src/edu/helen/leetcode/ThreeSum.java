package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 这道题让我们求三数之和，比之前那道Two Sum 两数之和要复杂一些，我们还是要首先对原数组进行排序，
 * 然后开始遍历排序后的数组，这里注意不是遍历到最后一个停止，而是到倒数第三个就可以了，
 * 然后我们还要加上重复就跳过的处理，对于遍历到的数，我们用0减去这个数得到一个sum，
 * 我们只需要再之后找到两个数之和等于sum即可，这样一来问题又转化为了求two sum，
 * 这时候我们一次扫描，找到了等于sum的两数后，加上当前遍历到的数字，按顺序存入结果中即可，然后还要注意跳过重复数字
 *
 *  time complexity O(n^2)
 * space complexity O(n)
 * Created by Helen on 9/18/2017.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0) break;
            if(nums[i]==nums[i+1]) continue;
            int low=i+1, high=nums.length-1;
            int sum = 0-nums[i];
            while(low<high){
                if(nums[low]+nums[high]==sum){
                    res.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    while(low<high&&nums[low]==nums[low+1]) low++;
                    while(low<high&&nums[high]==nums[high-1]) high--;
                    low++;
                    high--;
                }else if(nums[low]+nums[high]<sum){
                    low++;
                }else{
                    high--;
                }
            }
        }
        return res;
    }
}
