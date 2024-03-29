package com.helen.leetcode;

/**
 * 我们为了找规律，先把具体的数字抽象为A,B,C,D，那么我们可以得到：

 F(0) = 0A + 1B + 2C +3D

 F(1) = 0D + 1A + 2B +3C

 F(2) = 0C + 1D + 2A +3B

 F(3) = 0B + 1C + 2D +3A

 那么，我们通过仔细观察，我们可以得出下面的规律：

 F(1) = F(0) + sum - 4D

 F(2) = F(1) + sum - 4C

 F(3) = F(2) + sum - 4B

 那么我们就找到规律了, F(i) = F(i-1) + sum - n*A[n-i]，可以写出代码如下
 * Created by Helen on 10/19/2017.
 */
public class MaxRotateFunction {
    public int maxRotateFunction(int[] A) {
        if(A.length==0){
            return 0;
        }
        int sum=0;
        int t=0;
        int n = A.length;
        for(int i=0;i<n;i++){
            sum += A[i];
            t = t + i*A[i];
        }
        int res = t; // assign the F(0) to res
        for(int i=1;i<n;i++){
            t = t +sum - n*A[n-i];
            res = Math.max(res,t);
        }
        return res;
    }
}
