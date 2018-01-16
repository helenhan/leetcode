package edu.helen.leetcode;

/**
 * https://leetcode.com/problems/trapping-rain-water/solution/
 * Find maximum height of bar from the left end upto an index i in the array left_max.
 * Find maximum height of bar from the right end upto an index i in the array right_max.
 * Iterate over the height array and update ans:
 * Add min(max_left[i],max_right[i])−height[i] to ans
 * Created by Helen on 9/21/2017.
 */
public class TrappingWater {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        int area = 0;
        for (int j = height.length - 2; j >= 0; j--) {
            right[j] = Math.max(right[j + 1], height[j + 1]);
            int min = Math.min(left[j], right[j]);
            if (min > height[j]) {
                area += min - height[j];
            }
        }
        return area;
    }
}
