package com.leet.algo;

import java.util.Stack;

/**
 * Created by ayanc on 2/21/18.
 */
public class Prob42 {
  public int trap(int[] height) {
    if (height == null || height.length < 2) return 0;
    Stack<Integer> stack = new Stack<>();
    int i = 0;
    int result= 0;
    while (i < height.length) {
      int cur = height[i];
      if (stack.empty() || height[stack.peek()] >= cur) stack.push(i++);
      else {
        int lastI = stack.pop();
        while (!stack.isEmpty()) {
          int secondLastI = stack.pop();
          result += (i - secondLastI - 1) * (Math.min(height[i], height[secondLastI]) - height[lastI]);
          if (height[secondLastI] > height[lastI]) {
            stack.push(secondLastI);
            break;
          }
          lastI = secondLastI;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Prob42 prob42 = new Prob42();
    System.out.println(prob42.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
  }
}
