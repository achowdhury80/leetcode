package com.prep2020.medium;
import java.util.*;
public class Problem503 {
	/**
	 * O(N)
	 * @param nums
	 * @return
	 */
	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
        int[] result = new int[n];
        int max = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = 0; i < n; i++) {
        	if (nums[i] >= max) {
        		maxIndex = i;
        		max = nums[i];
        	}
        }
        Deque<Integer> stack = new ArrayDeque<>();
        result[maxIndex] = -1;
        stack.push(max);
        int i = maxIndex;
        i = i == 0 ? (n - 1) : (i - 1); 
        while(i != maxIndex) {
        	while(!stack.isEmpty() && nums[i] >=  stack.peek()) {
        		stack.pop();
        	}
        	if (stack.isEmpty()) result[i] = -1;
        	else result[i] = stack.peek();
        	stack.push(nums[i]);
        	i = i == 0 ? (n - 1) : (i - 1); 
        }
        return result;
    }
}
