package com.prep2020.medium;

import java.util.Stack;

public class Problem456 {
	public boolean find132pattern(int[] nums) {
	    if(nums == null || nums.length < 3) return false;
	    int s3 = Integer.MIN_VALUE;
	    Stack<Integer> stack = new Stack<>();
	    for (int i = nums.length - 1; i > -1; i--){
	      if(s3 > nums[i] && !stack.isEmpty()) return true;
	      else while(!stack.isEmpty() && nums[i] > stack.peek()){
	        s3 = stack.peek();
	        stack.pop();
	      }
	      stack.push(nums[i]);
	    }
	    return false;
	  }
}
