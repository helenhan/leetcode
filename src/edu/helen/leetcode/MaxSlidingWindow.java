package edu.helen.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://aaronice.gitbooks.io/lintcode/content/data_structure/sliding_window_maximum.html
 * 相比Sliding Window Median，这里寻找Maximum也许更容易一些，
 * 因为是一个局部极值，也许可以用stack或者queue来记录当前窗口的最大元素？
 * 但是单纯使用stack或者queue都不能很好地满足需要，因为想维护一个数据结构，
 * 能够保持其元素的单调递减性，其头部永远是当前window的maximum，
 * 如果有新的较大元素，则将该结构内比它小的元素都pop出来，再push新的较大元素
 * <p>
 * Created by Helen on 10/14/2017.
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k - 1; i++) {
            inQueue(deque, nums[i]);
        }
        int j = 0;
        for (int i = k - 1; i < n; i++) { //from k-1, because we get the first maximum from k-1
            inQueue(deque, nums[i]);
            result[j++] = deque.peekFirst();
            outQueue(deque, nums[i - k + 1]); //Note remove the first(index) num in window
        }
        return result;
    }

    private void inQueue(Deque<Integer> deque, int num) {
        while (!deque.isEmpty() && deque.peekLast() < num) {
            deque.pollLast();
        }
        deque.offerLast(num);
    }

    private void outQueue(Deque<Integer> deque, int num) {
        if (deque.peekFirst() == num) {
            deque.pollFirst();//this means the first element in deque is 'num' which will be out from deque.
        }
    }
}
