package edu.helen.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * http://www.cnblogs.com/grandyang/p/6545075.html
 * Created by Helen on 11/20/2017.
 */
public class KDiffPairs {
//
//  这道题给了我们一个含有重复数字的无序数组，还有一个整数k，让我们找出有多少对不重复的数对(i, j)使得i和j的差刚好为k。
//  由于k有可能为0，而只有含有至少两个相同的数字才能形成数对，那么就是说我们需要统计数组中每个数字的个数。
//  我们可以建立每个数字和其出现次数之间的映射，然后遍历哈希表中的数字，如果k为0且该数字出现的次数大于1，则结果res自增1；
//  如果k不为0，且用当前数字加上k后得到的新数字也在数组中存在，则结果res自增1
//
    public int findPairs(int[] nums, int k) {
        int count = 0;
        if(nums==null||nums.length==0||k<0) return count;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) { //Absolute difference
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) count++;
            }
        }
        return count;
    }
//    下面这种方法没有使用哈希表，而是使用了双指针，需要给数组排序，节省了空间的同时牺牲了时间。我们遍历排序后的数组，
//    然后在当前数字之后找第一个和当前数之差不小于k的数字，若这个数字和当前数字之差正好为k，那么结果res自增1，
//    然后遍历后面的数字去掉重复数字，参见代码如下
    public int findPairs2(int[] nums, int k) {
        Arrays.sort(nums);
        int j=0,res=0;
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            j = Math.max(j,i+1);
            while(j<n&& nums[i]+k>nums[j]) j++;
            if(j<n&&nums[i]+k==nums[j]) res++;
            while(i<n-1 && nums[i]==nums[i+1])i++;
        }
        return res;
    }


}
