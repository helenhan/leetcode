package com.helen.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://stomachache007.wordpress.com/2017/04/05/title4/#more-891
 * Created by Helen on 12/18/2017.
 */
public class IntersectionTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i]) && !set2.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }
        int[] res = new int[set2.size()];
        int index = 0;
        for (int num : set2) {
            res[index++] = num;
        }
        return res;
    }
}
