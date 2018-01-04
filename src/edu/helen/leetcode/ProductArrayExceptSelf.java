package edu.helen.leetcode;

/**
 * http://fisherlei.blogspot.ca/search?q=product
 * 一般这种题都可以分解成若干子问题来解决。As defined,
 * output[i] is equal to the product of all the elements of nums except nums[i].
 * 简单的说
 * output[i] =  { i 前面的数的乘积}  X  { i 后面的数的乘积}
 * 问题就解决了，首先从前往后扫描数组一遍，对每一个i，得到{i 前面的数的乘积}(可以称做output_before)，然后在从后往前扫描数组一遍，获得 { i 后面的数的乘积}(可以称做output_after)。 将两数相乘即为所求。
 * 举个例子(如下图)，nums = {1,2,3,4}, 第一遍，从前往后扫描一遍，得到的output_before = {1, 1, 2, 6}. 从后往前扫描一遍，得到的output_after = {24, 12, 4, 1}.
 * 那么  output [i] = output_before[i] * output_after[i],   output = {24, 12, 8, 6}
 * Created by Helen on 10/14/2017.
 */
public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        if (nums == null || nums.length == 0) return product;
        int tmp = 1;
        product[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            tmp *= nums[i - 1];
            product[i] = tmp;
        }
        tmp = 1;
        for (int j = nums.length - 2; j >= 0; j--) { // unnecessarily consider output-before of the first number and out-after for the last number,
            tmp *= nums[j + 1];                        // because both of them are 1 and 1 does not effect the final product
            product[j] *= tmp;
        }
        return product;
    }

}
