package com.helen.leetcode;

/**
 * Created by Helen on 11/23/2017.
 */
public class SolveEquation {
    public String solveEquation(String equation) {
        String[] strings = equation.split("=");
        int[] res = parseEquation(strings[0]);
        int[] res2 = parseEquation(strings[1]);
        res[0] -= res2[0]; //coefficient of x
        res[1] = res2[1] - res[1]; //constant
        if (res[0] == 0 && res[1] == 0) return "Infinite solutions";
        else if (res[0] == 0) return "No solution";
        else return "x=" + res[1] / res[0];


    }

    private int[] parseEquation(String str) {
        int[] res = new int[2];
        String[] tokens = str.split("(?=[+-])"); //[+-] means + or - ; (?= pattern) means /Win(?=98)/ matches only if there is a following pattern in input. Eg:  /Win(?=98)/ matches 'Win' only if 'Win' is followed by '98'.
        for (String token : tokens) {
            if (token.equals("+x") || token.equals("x")) res[0] += 1; // do not forget "x"
            else if (token.equals("-x")) res[0] -= 1;
            else if (token.contains("x")) res[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
            else {
                res[1] += Integer.parseInt(token);
            }
        }
        return res;
    }

}
