package com.prep2020.hard;
import java.util.*;
public class Problem1793 {
	public int maximumScore(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= nums.length; i++) {
            int h = i == nums.length ? Integer.MIN_VALUE : nums[i];
            while (!stack.isEmpty() && nums[stack.peek()] > h) {
			// current min
                int pop = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
				// check if subarray is good
                if (k >= left + 1 && k <= i - 1) {
                    max = Math.max(max, nums[pop] * (i - left - 1));
                }
            }
            stack.push(i);
        }
        return max;
    }
}
