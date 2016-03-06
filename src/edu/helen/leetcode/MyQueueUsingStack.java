package edu.helen.leetcode;

import java.util.Stack;

public class MyQueueUsingStack {
	Stack<Integer> first = null;
	Stack<Integer> second = null;
	int peek;

	public MyQueueUsingStack() {
		first = new Stack<>();
		second = new Stack<>();
	}

	// Push element x to the back of queue.
	public void push(int x) {
		if (first.empty()) {
			peek = x;
		}
		first.push(x);

	}

	// Removes the element from in front of queue.
	public void pop() {
		while (!first.isEmpty()) {
			second.push(first.pop());
		}
		second.pop();
		if (!second.empty()) {
			peek = second.peek();
		}
		while (!second.isEmpty()) {
			first.push(second.pop());
		}
	}

	// Get the front element.
	public int peek() {
		return this.peek;
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return first.isEmpty();
	}

}
