package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Helen on 9/23/2017.
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(res,new ArrayList<>(),nums,new boolean[nums.length]);
        return res;
    }

    private void backTrack(List<List<Integer>> res,List<Integer> list,int[] nums,boolean[] used){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
        }else{
            for(int i=0;i<nums.length;i++){
                if(used[i]) continue;
                if(i>0&&nums[i]==nums[i-1]&&!used[i-1]) continue;
                used[i] = true;
                list.add(nums[i]);

                backTrack(res,list,nums,used);
                used[i]= false;
                list.remove(list.size()-1);
            }
        }
    }
}
