package com.helen.leetcode;

/**
 * Created by Helen on 3/4/2018.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            switch (ch) {
                case 'I':
                    res += res >= 5 ? -1 : 1;
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10 * (res >= 50 ? -1 : 1);
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100 * (res >= 500 ? -1 : 1);
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RomanToInteger rti = new RomanToInteger();
        System.out.println(rti.romanToInt("CCXLVI"));//246
    }

}
