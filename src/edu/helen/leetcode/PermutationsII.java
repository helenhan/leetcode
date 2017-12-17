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
        if(nums==null||nums.length==0) return res;
        Arrays.sort(nums);
        backTrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                list.add(nums[i]);

                backTrack(res, list, nums, used);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        helper(res, new ArrayList<Integer>(), nums, visited);
        return res;

    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]&&!visited[i-1]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            helper(res,list,nums,visited);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        PermutationsII permutation = new PermutationsII();
        permutation.permuteUnique2(new int[]{1,1,2});
    }

}
