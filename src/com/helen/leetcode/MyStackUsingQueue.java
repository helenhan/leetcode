package com.helen.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackUsingQueue {
	Queue<Integer> queue = null;

	public MyStackUsingQueue() {
		queue = new LinkedList<Integer>();
	}

	// Push element x onto stack.
	public void push(int x) {
		queue.add(x);
		for (int i = 1; i < queue.size(); i++) {
			queue.add(queue.poll());
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		queue.poll();
	}

	// Get the top element.
	public int top() {
		return queue.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return queue.isEmpty();
	}

}
