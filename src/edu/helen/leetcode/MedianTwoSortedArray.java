package edu.helen.leetcode;

/**
 * http://blog.csdn.net/yutianzuijin/article/details/11499917
 * https://stomachache007.wordpress.com/2017/04/05/title4/#more-891
 * Created by Helen on 12/21/2017.
 */
public class MedianTwoSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return findKth(nums1, 0, nums2, 0, len / 2 + 1); //the number of m+n is odd
        } else {
            return (findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0; //even
        }
    }

    private int findKth(int[] A, int AStart, int[] B, int BStart, int k) {
        if (AStart >= A.length) {
            return B[BStart + k - 1];
        }
        if (BStart >= B.length) {
            return A[AStart + k - 1];
        }
        if (k == 1) {
            return Math.min(A[AStart], B[BStart]);//the smaller one between A[0] and B[0];
        }
        int AKey = AStart + k / 2 - 1 < A.length ? A[AStart + k / 2 - 1] : Integer.MAX_VALUE;
        int BKey = BStart + k / 2 - 1 < B.length ? B[BStart + k / 2 - 1] : Integer.MAX_VALUE;
        if (AKey < BKey) {
            return findKth(A, AStart + k / 2, B, BStart, k - k / 2);
        } else {
            return findKth(A, AStart, B, BStart + k / 2, k - k / 2);
        }
    }
}
