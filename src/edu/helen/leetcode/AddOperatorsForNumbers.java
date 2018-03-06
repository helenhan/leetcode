package edu.helen.leetcode;

/**
 * Created by Helen on 2/25/2018.
 */
public class AddOperatorsForNumbers {

    char op[] = {'+', '*', '^'};

    boolean eval(int a[], int target, int n, int pos, int prev) {
        if (pos == n) {
            if (prev == target) {
                return true;
            }
            return false;
        }
        for (int i = 0; i < 3; i++) {
            int res = 0;
            char ch = op[i];
            if (ch == '+') {
                res = prev + a[pos];
            } else if (ch == '*') {
                res = prev * a[pos];
            } else if(ch=='^'){
                res = (int)Math.pow(prev , a[pos]);
            }
            if (eval(a, target, n, pos + 1, res))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        AddOperatorsForNumbers aof = new AddOperatorsForNumbers();
        System.out.println(aof.eval(new int[]{1, 3, 6, 8}, 5480, 4, 0, 0));
    }
}
