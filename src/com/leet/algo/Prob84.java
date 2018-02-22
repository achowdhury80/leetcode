package com.leet.algo;

import java.util.Stack;

/**
 * Created by ayanc on 2/21/18.
 */
public class Prob84 {
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

  public static void main(String[] args) {
    Prob84 prob84 = new Prob84();
    System.out.println(prob84.largestRectangleArea(new int[]{2,1,5,6,2,3}));
  }
}
