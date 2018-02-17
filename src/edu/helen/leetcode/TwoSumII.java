package edu.helen.leetcode;

/**
 * Created by Helen on 9/27/2017.
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers.length == 0 || numbers.length < 2) return res;
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int tmp = numbers[left] + numbers[right];
            if (numbers[left] + numbers[right] == target) {
                res[0] = left + 1; // indices are not zero-based
                res[1] = right + 1;
                return res;
            } else if (tmp < target) {
                left++;
            } else if (tmp > target) {
                right--;
            }
        }
        return res;
    }
}



