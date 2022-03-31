package com.helen.leetcode;

/**
 * Created by Helen on 2/7/2018.
 */
public class CompareVersions {
    public int compareVersion(String version1, String version2) {
        String[] v1Strs = version1.split("\\.");
        String[] v2Strs = version2.split("\\.");
        int level = v1Strs.length > v2Strs.length ? v1Strs.length : v2Strs.length;
        for (int i = 0; i < level; i++) {
            Integer v1 = i < v1Strs.length ? Integer.parseInt(v1Strs[i]) : 0;
            Integer v2 = i < v2Strs.length ? Integer.parseInt(v2Strs[i]) : 0;
            if (v1.compareTo(v2) != 0) {
                return v1.compareTo(v2);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        CompareVersions cs = new CompareVersions();
        cs.compareVersion("1.0","1.1");
    }
}
