package com.helen.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyCalculator {

	public MyCalculator() {
		// TODO Auto-generated constructor stub
	}

	public int calculate(String s) {
		Deque<Integer> stack = new ArrayDeque<>();
		int result = 0;
		int sign = 1;
		int sum = 0;
		int len = s.length();
		String str = s.trim();
		if (str.length() == 0) {
			return -1;
		}

		for (int i = 0; i < len; i++) {
			if (Character.isDigit(s.charAt(i))) {
				sum = s.charAt(i) - '0';
				while (i+1 <len && Character.isDigit(s.charAt(i+1))) {
					sum = sum * 10 + s.charAt(i+1) - '0';
					i++;
				}
				result += sum * sign;
			} else if (s.charAt(i) == '+') {
				sign = 1;
			} else if (s.charAt(i) == '-') {
				sign = -1;
			} else if (s.charAt(i) == '(') {
				stack.push(result);
				stack.push(sign);
				sign = 1;
				result = 0;
			} else if (s.charAt(i) == ')') {
				result = result * stack.pop()+stack.pop();
			}
		}
		return result;

	}
}
