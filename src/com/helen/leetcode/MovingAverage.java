package com.helen.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/moving-average-from-data-stream/discuss/81491/Java-O(1)-time-solution.
 * The idea is to keep the sum so far and update the sum just by replacing the oldest number with the new entry.
 * Created by Helen on 3/3/2018.
 */
public class MovingAverage {
    private Queue<Integer> queue;
    double sum = 0;
    int s;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        s = size;
    }

    public double next(int val) {
        if(queue.size()==s){
            int temp = queue.poll();
            sum = sum- temp;
        }
        sum += val;
        queue.offer(val);
        return sum/queue.size();
    }
}
