package com.prep2020.hard;
import java.util.*;
public class Problem84 {
	public int largestRectangleArea(int[] heights) {
	    if (heights == null || heights.length < 1) return 0;
	    int max = 0;
	    Stack<Integer> stack = new Stack<>();
	    int i = 0;
	    while(i <= heights.length) {
	      int cur = i == heights.length ? 0 : heights[i];
	      if (stack.isEmpty() || cur >= heights[stack.peek()]) stack.push(i++);
	      else {
	        int tp = stack.pop();
	        max = Math.max(max, heights[tp] * (stack.isEmpty() ? i : i - stack.peek() - 1));
	      }
	    }
	    return max;
	  }
}
