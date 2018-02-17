package edu.helen.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

//    // store difference in the stack and record min
//    Stack<Long> stack = new Stack<>();
//    long min = 0;
//    public MinStack(){
//
//    }
//    public void push(int x) {
//        if(stack.isEmpty()){
//            stack.push(0L);
//            min = x;
//        }else{
//            stack.push(x-min);
//            if(x<min){
//                min = x;
//            }
//        }
//
//    }
//
//    public void pop() {
//        if(stack.isEmpty()){
//            return;
//        }else{
//            long pop = stack.pop();
//            if(pop<0){
//                min = min-pop; // because x- the last min = pop, now x is popped,  we want to recover the last min, so last min is x-pop and x is the current min.
//                //last min means minimum number before x is pushed, current min standards minimum number after x is pushed.
//            }
//        }
//    }
//
//    public int top() {
//        long top = stack.peek();
//        if(top>0){
//            return (int)(min+top);
//        }else{
//            return (int)min;
//        }
//    }
//
//    public int getMin() {
//        return (int) min;
//    }


//    Two stacks

    Deque<Integer> stack = new LinkedList<>();
    Deque<Integer> minStack = new LinkedList<>();

    public MinStack() {

    }

    public void push(int x) {
        if (minStack.isEmpty() || x <= minStack.peek()) { // must be x<= not x<
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int num = stack.pop();
        if (minStack.peek() == num) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        stack.push(-3);
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());

    }


}
