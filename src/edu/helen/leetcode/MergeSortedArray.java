package edu.helen.leetcode;

/**
 *
 * Created by Helen on 12/18/2017.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int p = n - 1;
        int k = m + n - 1;
        while (i >= 0 && p>=0) {
            if (nums1[i] > nums2[p]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[p--];
            }

        }
        // Either i or j could have a chance to drop below zero first. But if it’s i, noting needed to be done, cause it’s already in array nums1.
        while(p>=0){
            nums1[k--] = nums2[p--];
        }
    }

    public static void main(String[] args) {
        MergeSortedArray msa = new MergeSortedArray();
        msa.merge(new int[]{1,0},1,new int[]{2},1);
    }
}
