package com.helen.leetcode;

import java.util.*;

/**
 * Created by Helen on 2/12/2018.
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        if(nums1==null||nums2==null||nums1.length==0||nums2.length==0){
            return new int[0];
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i],map.get(nums1[i])+1);
            }else{
                map.put(nums1[i],1);
            }
        }
        for(int i=0;i<nums2.length;i++){
            if(map.containsKey(nums2[i])&&map.get(nums2[i])>0){
                list.add(nums2[i]);
                map.put(nums2[i],map.get(nums2[i])-1);
            }
        }

        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        IntersectionOfTwoArraysII iot = new IntersectionOfTwoArraysII();
        iot.intersect(new int[]{1,2,2,1},new int[]{2});
    }
}
