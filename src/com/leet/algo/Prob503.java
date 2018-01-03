package com.leet.algo;

import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 1/2/18.
 */
public class Prob503 {
  public int[] nextGreaterElements(int[] nums) {
    if(nums == null || nums.length == 0) return null;
    if(nums.length < 2) return new int[]{-1};
    int[] result = new int[nums.length];
    Stack<Integer> stack = new Stack<>();
    for(int i = nums.length - 1; i > -1; i--) stack.push(i);
    for(int i = nums.length - 1; i > -1; i--){
      result[i] = -1;
      while (!stack.empty() && nums[stack.peek()] <= nums[i]){
        stack.pop();
      }
      if(!stack.isEmpty()) result[i] = nums[stack.peek()];
      stack.push(i);
    }
    return result;
  }
}
