package com.helen.leetcode;

/**
 * Created by Helen on 2/25/2018.
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        return n>0 && (n==1 || (n%3==0&&isPowerOfThree(n/3)));
    }
}
