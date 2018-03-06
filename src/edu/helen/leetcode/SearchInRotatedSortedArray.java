package edu.helen.leetcode;

/**
 * http://www.cnblogs.com/grandyang/p/4325648.html
 * https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14472/Java-AC-Solution-using-once-binary-search
 * The idea is that when rotating the array, there must be one half of the array that is still in sorted order.
 * For example, 6 7 1 2 3 4 5, the order is disrupted from the point between 7 and 1. So when doing binary search,
 * we can make a judgement that which part is ordered and whether the target is in that range, if yes, continue the search in that half, if not continue in the other half.
 * Created by Helen on 2/21/2018.
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else {
                if (nums[mid] < nums[high]) {
                    if (nums[mid] < target && nums[high] >= target) low = mid + 1;
                    else high = mid - 1;
                } else {
                    if (nums[mid] > target && nums[low] <= target) high = mid - 1;
                    else low = mid + 1;
                }
            }
        }
        return -1;
    }
}
