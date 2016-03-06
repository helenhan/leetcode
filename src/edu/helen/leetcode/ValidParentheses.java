package edu.helen.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

	public ValidParentheses() {
		// TODO Auto-generated constructor stub
	}

	public boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		Deque<Character> stack = new ArrayDeque<>();
		if ((s.length() % 2) != 0) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '(':
			case '[':
			case '{':
				stack.push(c);
				break;
			case ')':
				if (stack.isEmpty()) {
					return false;
				} else if (stack.pop() != '(') {
					return false;
				}
				break;
			case ']':
				if (stack.isEmpty()) {
					return false;
				} else if (stack.pop() != '[') {
					return false;
				}
				break;
			case '}':
				if (stack.isEmpty()) {
					return false;
				} else if (stack.pop() != '{') {
					return false;
				}
				break;
			}

		}

		if (stack.size() != 0) {
			return false;
		}
		return true;
	}

}
