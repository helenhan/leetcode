package com.helen.leetcode;

/**
 * http://www.cnblogs.com/grandyang/p/4843654.html
 * https://leetcode.com/problems/find-the-duplicate-number/discuss/72845/Java-O(n)-time-and-O(1)-space-solution.-Similar-to-find-loop-in-linkedlist.
 * Created by Helen on 2/12/2018.
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int low = 1; // Note, start from 1
        int high = nums.length - 1; //because the biggest number in nums is nums.length-1.

        while (low < high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        FindDuplicate fd = new FindDuplicate();
        System.out.println(fd.findDuplicate(new int[]{2,5,1,1,4,3}));
    }
}
