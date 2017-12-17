package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://discuss.leetcode.com/topic/46159/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/2
 * 时间复杂度

 答案个数不知道, 假设为S;

 每个答案用的时间=target;

 所以总的时间复杂度= O(S*target), 是个NP问题

 * Created by Helen on 12/6/2017.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int target, int index) {
        if (target < 0) {
            return;

        } else if (target == 0) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = index; i < nums.length; i++) {
                list.add(nums[i]);
                helper(res, list, nums, target - nums[i], i); // not i + 1 because we can reuse same elements
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum sum = new CombinationSum();
        sum.combinationSum(new int[]{2, 3, 6}, 7);
    }
}
