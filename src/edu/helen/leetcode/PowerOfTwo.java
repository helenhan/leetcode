package edu.helen.leetcode;

/**
 * Created by Helen on 2/25/2018.
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        while(n%2==0){
            n/=2;
        }
        return n==1;
    }

    public boolean isPowerOfTwo2(int n) {
        return n>0 &&(n==1||(n%2==0 && isPowerOfTwo2(n/2)));
    }
}
