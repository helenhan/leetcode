package edu.helen.leetcode;

/**
 * https://leetcode.com/problems/excel-sheet-column-number/discuss/52107/My-solutions-in-3-languages-does-any-one-have-one-line-solution-in-Java-or-C++
 * Created by Helen on 3/4/2018.
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
