package com.helen.leetcode;

/**
 * Created by Helen on 2/7/2018.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            carry = sum / 2;
            builder.append(sum % 2);
        }
        if (carry != 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary ab = new AddBinary();
        System.out.println(ab.addBinary("11", "1"));
    }
}
