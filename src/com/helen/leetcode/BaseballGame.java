package com.helen.leetcode;

import java.util.Stack;

/**
 * https://discuss.leetcode.com/topic/104705/verbose-java-solution-linkedlist/10
 * Created by Helen on 11/25/2017.
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (String op : ops) {
            if (op.equals("C")) {
                sum -= stack.pop();
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
                sum += stack.peek();
            } else if (op.equals("+")) {
                int last = stack.pop();
                int value = stack.peek() + last;
                stack.push(last);
                stack.push(value);
                sum += stack.peek();
            } else {
                stack.push(Integer.parseInt(op));
                sum += stack.peek();
            }
        }
        return sum;
    }

}
