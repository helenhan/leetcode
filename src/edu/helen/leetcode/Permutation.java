package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Helen on 9/23/2017.
 */
public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res,new ArrayList(),nums);
        return res;
    }
    private void backTrack(List<List<Integer>> res,ArrayList list,int[] nums){
        if(list.size()==nums.length) {
            res.add(new ArrayList<>(list));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])) continue;
                list.add(nums[i]);
                backTrack(res, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}
