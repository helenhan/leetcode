package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://stomachache007.wordpress.com/2017/03/22/%E4%B9%9D%E7%AB%A0%E7%AE%97%E6%B3%95%E7%AC%94%E8%AE%B0-5-%E6%B7%B1%E5%BA%A6%E4%BC%98%E5%85%88%E6%90%9C%E7%B4%A2-depth-first-search/#more-786
 *
 * –构造每个答案的时间 * 答案的个数
 * =O(n!  * n)
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
