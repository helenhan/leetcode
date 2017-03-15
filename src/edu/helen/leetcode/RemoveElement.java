package edu.helen.leetcode;

/**
 * Created by Helen on 3/13/2017.
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int begin = 0;
        if(nums==null){
            return begin;
        }
        for(int i= 0; i<nums.length;i++){
            if(nums[i]!=val){
                nums[begin++] = nums[i];
            }
        }
        return begin;
    }

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        re.removeElement(new int[]{},3);
    }
}
