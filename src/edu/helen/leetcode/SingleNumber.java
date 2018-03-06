package edu.helen.leetcode;

/**
 * known that A XOR A = 0 and the XOR operator is commutative, the solution will be very straightforward.
 * Let’s say we have an array - [2,1,4,5,2,4,1].
 What we are doing is essentially this-

 => 0 ^ 2 ^ 1 ^ 4 ^ 5 ^ 2 ^ 4 ^ 1

 => 0^ 2^2 ^ 1^1 ^ 4^4 ^5 (Rearranging, taking same numbers together)

 => 0 ^ 0 ^ 0 ^ 0 ^ 5

 => 0 ^ 5

 => 5 :)

 * Created by Helen on 3/4/2018.
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i=0;i<nums.length;i++){
            result ^= nums[i];

        }
        return result;
    }
}
