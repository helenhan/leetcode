package edu.helen.leetcode;

public class LargestRectHistogram {

	public LargestRectHistogram() {
		// TODO Auto-generated constructor stub
	}

	// https://leetcode.com/discuss/84911/geeks-for-geeks-thought-on-how-to-solve-the-problem

	// The key idea is referred from
	// http://www.geeksforgeeks.org/largest-rectangle-under-histogram/, to get
	// the rectangle value of item i, we need to find the first left item lower
	// than height[i] and the first right item lower than height[i].
	// Rectangle[i] = (rightr - left) * height[i]. (Rectangle[i] is the max
	// rectangle for item i). Then output the maximum one of Rectangle[i]
	// (i=0..n-1).
	public int largestRectangleArea(int[] heights) {
		
	}

}
