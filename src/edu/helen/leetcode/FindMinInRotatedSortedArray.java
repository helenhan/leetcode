package edu.helen.leetcode;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/discuss/48484/A-concise-solution-with-proof-in-the-comment
 * Really the BEST solution!! Binary search always bothers me, thanks for sharing. Followings are my understanding from the comments as others reference.

 (1) loop is left < right, which means inside the loop, left always < right
 (2 ) since we use round up for mid, and left < right from (1), right would never be the same as mid
 (3) Therefore, we compare mid with right, since they will never be the same from (2)
 (4) if nums[mid] < nums[right], we will know the minimum should be in the left part, so we are moving right.
 We can always make right = mid while we don’t have to worry the loop will not ends. Since from (2), we know right would never be the same as mid, making right = mid will assure the interval is shrinking.
 (5) if nums[mid] > nums[right], minimum should be in the right part, so we are moving left. Since nums[mid] > nums[right],mid can’t be the minimum, we can safely move left to mid + 1, which also assure the interval is shrinking
 * Created by Helen on 2/21/2018.
 */
public class FindMinInRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        // loop invariant: 1. low < high
        //                 2. mid != high and thus A[mid] != A[high] (no duplicate exists)
        //                 3. minimum is between [low, high]
        // The proof that the loop will exit: after each iteration either the 'high' decreases
        // or the 'low' increases, so the interval [low, high] will always shrink.
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return nums[low];
    }
}
