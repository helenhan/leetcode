package com.helen.leetcode;

import java.util.Stack;

public class ValidParentheses {

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for(char c:s.toCharArray()){
			if(c=='(') stack.push(')');
			else if(c=='[') stack.push(']');
			else if(c=='{') stack.push('}');
			else if(stack.empty()||stack.pop()!=c) return false; //do not forget to check stack.empty()   // the number of right parentheses less than left ones
		}
		return stack.empty(); //the number of left parentheses is bigger than right ones.
	}
}
