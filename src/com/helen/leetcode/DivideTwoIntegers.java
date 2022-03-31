package com.helen.leetcode;

/**
 * http://www.cnblogs.com/grandyang/p/4431949.html
 * Created by Helen on 3/4/2018.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long m = Math.abs((long) dividend);
        long n = Math.abs((long) divisor);
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        int res = 0;
        while (m >= n) {
            long t = n, p = 1;
            while (m > (t << 1)) {
                t <<= 1;
                p <<= 1;
            }
            res += p;
            m -= t;
        }
        return sign == 1 ? res : -res;
    }

    public static void main(String[] args) {
        DivideTwoIntegers dt = new DivideTwoIntegers();
        dt.divide(10, 5);
    }
}
