package com.helen.leetcode;

import java.util.Stack;

/**
 * 准备两个stack，stack1和stack2
 * <p>
 * 放stack1里放正了，再倒到stack2里 就倒过来了，push就push倒stack1里，pop要从stack2里pop
 */
public class MyQueueUsingStack {

    Stack<Integer> first;
    Stack<Integer> second;
    int peek;

    /**
     * Initialize your data structure here.
     */
    public MyQueueUsingStack() {
        first = new Stack<>();
        second = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (first.isEmpty()) {
            peek = x;
        }
        first.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int x = second.pop();
        if (!second.isEmpty()) {
            this.peek = second.peek();
        }
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return x;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return this.peek;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return first.isEmpty();
    }
}

