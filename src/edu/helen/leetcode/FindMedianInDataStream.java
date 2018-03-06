package edu.helen.leetcode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/discuss/74062/Short-simple-JavaC++Python-O(log-n)-+-O(1)
 * I keep two heaps (or priority queues):

 Max-heap small has the smaller half of the numbers.
 Min-heap large has the larger half of the numbers.
 This gives me direct access to the one or two middle values (they’re the tops of the heaps), so getting the median takes O(1) time. And adding a number takes O(log n) time.

 Supporting both min- and max-heap is more or less cumbersome, depending on the language, so I simply negate the numbers in the heap in which I want the reverse of the default order.
 To prevent this from causing a bug with -231 (which negated is itself, when using 32-bit ints), I use integer types larger than 32 bits.

 Using larger integer types also prevents an overflow error when taking the mean of the two middle numbers. I think almost all solutions posted previously have that bug.

 * Created by Helen on 3/2/2018.
 */
public class FindMedianInDataStream {

    PriorityQueue<Long> small = new PriorityQueue<>();
    PriorityQueue<Long> large = new PriorityQueue<>();
    /** initialize your data structure here. */
    public FindMedianInDataStream() {

    }

    public void addNum(int num) {
        large.add((long)num);
        small.add(-large.poll());
        if(large.size()<small.size()){
            large.add(-small.poll());
        }
    }

    public double findMedian() {
        return large.size()>small.size()? large.peek(): (large.peek()-small.peek())/2.0;
    }

    public static void main(String[] args) {
        FindMedianInDataStream fm = new FindMedianInDataStream();
        fm.addNum(4);
        fm.addNum(2);
        System.out.println(fm.findMedian());
        fm.addNum(3);
        fm.addNum(5);
        fm.addNum(1);
        System.out.println(fm.findMedian());
    }
}
