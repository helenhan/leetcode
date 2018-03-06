package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/discuss/81969/Three-Java-Solutions
 * two sets, sort and two pointers, sort and binary search
 * Created by Helen on 3/5/2018.
 */
public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null||nums2==null||nums1.length==0||nums2.length==0){
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        for(int num:nums2){
            set.add(num);
        }
        Set<Integer> res = new HashSet<>();
        for(int num:nums1){
            if(set.contains(num)){
                res.add(num);
            }
        }
        int[] result = new int[res.size()];
        int k=0;
        for(int num:res){
            result[k++] = num;

        }
        return result;
    }
}
