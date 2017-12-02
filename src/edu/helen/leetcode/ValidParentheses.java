package edu.helen.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ValidParentheses {

	public ValidParentheses() {
		// TODO Auto-generated constructor stub
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(char c:s.toCharArray()){
			if(c=='(') stack.push(')');
			else if(c=='[') stack.push(']');
			else if(c=='{') stack.push('}');
			else if(stack.empty()||stack.pop()!=c) return false;
		}
		return stack.empty();
	}



}
