package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * My idea is to generate the sequence iteratively. For example, when n=3, we can get the result based on n=2.
 * 00,01,11,10 -> (000,001,011,010 ) (110,111,101,100). The middle two numbers only differ at their highest bit,
 * while the rest numbers of part two are exactly symmetric of part one. It is easy to see its correctness.
 * <p>
 * n = i的grey code的前一半包括了n = i-1的所有grey code，而后一半则为前一半逆序后家上2^(i-1)。
 * <p>
 * Created by Helen on 9/21/2017.
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0); // remember to add 0 first
        for (int i = 0; i < n; i++) {
            int highest = 1 << i; //move i bits.
            int size = res.size();
            for (int j = size - 1; j >= 0; j--) {
                int num = res.get(j);
                num += highest;
                res.add(num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GrayCode cc = new GrayCode();
        cc.grayCode(3);
    }
}
