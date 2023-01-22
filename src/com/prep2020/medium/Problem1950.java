package com.prep2020.medium;

import java.util.*;

public class Problem1950 {
	/*
    The span of an element is defined as the largest subarray containing 
    the element for which the element is the minimum of that array
  */
  private class Span {
    // The index of the first element to the left less than the current element
    public int leftIdx;
    
    // The index of the first element to the right less than the current element
    public int rightIdx;
  }
  
  public int[] findMaximums(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n]; for (int i = 0; i < n; ++i) ans[i] = -1;
    
    // We first compute the span for each element
    Span[] spans = getSpans(nums);
    
    for (int i = 0; i < n; ++i) {
      // Compute the length of the span
      int spanLength = spans[i].rightIdx - spans[i].leftIdx + 1;
      
      // This value is a valid candidate for the (spanLength - 1)th query
      ans[spanLength - 1] = Math.max(ans[spanLength - 1], nums[i]);
    }
    
    /*
      A value that is the minimum of a subarray of length L is also a minimum
      of some subarray of length L - x for some non-zero x
    */
    int curValue = -1;
    for (int i = n - 1; i >= 0; --i) {
      ans[i] = Math.max(curValue, ans[i]);
      curValue = ans[i];
    }
    
    return ans;
  }
  
  private Span[] getSpans(int[] nums) {
    int n = nums.length;
    Span[] spans = new Span[n];
    for (int i = 0; i < n; ++i) spans[i] = new Span();
    
    // Use a stack to compute the left index of the span for each element
    Stack<Integer> leftStack = new Stack<Integer>();
    for (int i = 0; i < n; ++i) {
      // Pop until an element smaller than the current one is found
      while (!leftStack.empty() && nums[leftStack.peek()] >= nums[i]) {
        leftStack.pop();
      }
      if (!leftStack.empty()) {
        spans[i].leftIdx = leftStack.peek() + 1;
      } else {
        spans[i].leftIdx = 0;
      }
      leftStack.push(i);
    }
    
    // Similarly, use a stack to compute the right index of the span for each element
    Stack<Integer> rightStack = new Stack<Integer>();
    for (int i = n - 1; i >= 0; --i) {
      // Pop until an element smaller than the current one is found
      while (!rightStack.empty() && nums[rightStack.peek()] >= nums[i]) {
        rightStack.pop();
      }
      if (!rightStack.empty()) {
        spans[i].rightIdx = rightStack.peek() - 1;
      } else {
        spans[i].rightIdx = n - 1;
      }
      rightStack.push(i);
    }
    
    return spans;
  }
	
	public static void main(String[] args) {
		Problem1950 problem = new Problem1950();
		System.out.println(problem.findMaximums(new int[] {0, 1, 2, 4}));
	}
}
