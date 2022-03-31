package com.helen.leetcode;

/**
 * Created by Helen on 11/9/2017.
 */
public class ComplexNumberMultiply {
    public String complexNumberMultiply(String a, String b) {
        String x[] = a.split("\\+|i"); // "|i" means finding i, two backslashes :first is for the second ,second is for +
        String y[] = b.split("\\+|i");
        int aReal = Integer.parseInt(x[0]);
        int aImg = Integer.parseInt(x[1]);
        int bReal = Integer.parseInt(y[0]);
        int bImg = Integer.parseInt(y[1]);
        return aReal * bReal - aImg * bImg + "+" + (aReal * bImg + aImg * bReal) + "i";
    }
}
