package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinStack {

//	private List<Integer> stack;
//	private List<Integer> minStack;
//
//	public MinStack() {
//		stack = new ArrayList<>();
//		minStack = new ArrayList<>();
//	}
//
//
//	public void push(int x) {
//		stack.add(x);
//		if (minStack.isEmpty()) {
//			minStack.add(x);
//		} else if (minStack.get(minStack.size() - 1) >= x) {
//			minStack.add(x);
//		}
//
//	}
//
//	public void pop() {
//		if (stack.get(stack.size() - 1) == minStack.get(minStack.size() - 1)) {
//			minStack.remove(minStack.size() - 1);
//		}
//		stack.remove(stack.size() - 1);
//	}
//
//	public int top() {
//		return stack.isEmpty() ? Integer.MIN_VALUE : stack
//				.get(stack.size() - 1);
//	}
//
//	public int getMin() {
//		if (stack.isEmpty() && minStack.isEmpty()) {
//			return Integer.MIN_VALUE;
//		} else {
//			return minStack.get(minStack.size() - 1);
//		}
//	}

	Stack<Long> stack = new Stack<>();
	long min = 0;
	public MinStack(){

	}
	public void push(int x) {
		if(stack.isEmpty()){
			stack.push(0L);
			min = x;
		}else{
			stack.push(x-min);
			if(x<min){
				min = x;
			}
		}

	}

	public void pop() {
		if(stack.isEmpty()){
			return;
		}else{
			long pop = stack.pop();
			if(pop<0){
				min = min-pop;
			}
		}
	}

	public int top() {
		long top = stack.peek();
		if(top>0){
			return (int)(min+top);
		}else{
			return (int)min;
		}
	}

	public int getMin() {
		return (int) min;
	}

}
