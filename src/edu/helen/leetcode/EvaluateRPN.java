package edu.helen.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateRPN {

	public EvaluateRPN() {
		// TODO Auto-generated constructor stub
	}

	public int evalRPN(String[] tokens) {
        
		if(tokens==null||tokens.length==0){
			return 0;
		}else if(tokens.length==1){
		    return Integer.valueOf(tokens[0]);
		}
		Deque<Integer> stack = new ArrayDeque<>();
		int result = 0;
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+")) {
				result = stack.pop() + stack.pop();
				stack.push(result);
			} else if (tokens[i].equals("-")) {
				int temp = stack.pop();
				result = stack.pop() - temp;
				stack.push(result);
			} else if (tokens[i].equals("/")) {
				int temp = stack.pop();
				result = stack.pop() / temp;
				stack.push(result);
			} else if (tokens[i].equals("*")) {
				result = stack.pop() * stack.pop();
				stack.push(result);
			} else {
				stack.push(Integer.valueOf(tokens[i]));
			}
		}
		return result;
	
    }

}
