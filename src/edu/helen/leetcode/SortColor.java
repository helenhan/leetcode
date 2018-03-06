package edu.helen.leetcode;

import java.util.Arrays;

/**
 * 三个指针l, r, i
 * <p>
 * i指针, 从左到右
 * <p>
 * 遇到0: i和l换, 左边扩大1， i++
 * <p>
 * 遇到2: i和r换, 右边减少1, i不动
 * <p>
 * 遇到1: 接着走,不做处理
 * Created by Helen on 12/27/2017.
 */
public class SortColor {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = 0, pl = 0, pr = nums.length - 1;
        while (i <= pr) {
            if (nums[i] == 0) {
                swap(nums, i, pl);
                i++;
                pl++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, pr);
                pr--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        SortColor sc = new SortColor();
        int[] nums = new int[]{0, 1, 0, 2, 2, 1};
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
