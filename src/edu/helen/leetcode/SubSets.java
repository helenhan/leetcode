package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Helen on 9/23/2017.
 */
public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,new ArrayList<>(),nums,0);
        return result;
    }

    public void backtrack(List<List<Integer>> res,List<Integer> list,int[] nums,int start){
        res.add(new ArrayList<>(list));
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            backtrack(res,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}
