package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Helen on 12/6/2017.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // must be sorted first since we need to remove duplicates later
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int target, int start) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {// skip duplicates
                    continue;
                }
                list.add(nums[i]);
                helper(res, list, nums, target - nums[i], i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
