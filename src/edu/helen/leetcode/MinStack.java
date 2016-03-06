package edu.helen.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

	private List<Integer> stack;
	private List<Integer> minStack;

	public MinStack() {
		stack = new ArrayList<>();
		minStack = new ArrayList<>();
	}
		

	public void push(int x) {
		stack.add(x);
		if (minStack.isEmpty()) {
			minStack.add(x);
		} else if (minStack.get(minStack.size() - 1) >= x) {
			minStack.add(x);
		}

	}

	public void pop() {
		if (stack.get(stack.size() - 1) == minStack.get(minStack.size() - 1)) {
			minStack.remove(minStack.size() - 1);
		}
		stack.remove(stack.size() - 1);
	}

	public int top() {
		return stack.isEmpty() ? Integer.MIN_VALUE : stack
				.get(stack.size() - 1);
	}

	public int getMin() {
		if (stack.isEmpty() && minStack.isEmpty()) {
			return Integer.MIN_VALUE;
		} else {
			return minStack.get(minStack.size() - 1);
		}
	}

}
