package com.prep2020.hard;
import java.util.*;
public class Problem1063 {
	/**
	 * O(N) time and space
	 * @param nums
	 * @return
	 */
	public int validSubarrays(int[] nums) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int lastIndex = -1;
        for (int i = 0; i < nums.length; i++) {
        	while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
        		lastIndex = stack.pop();
        		result += (i - lastIndex);
        	}
        	stack.push(i);
        }
        lastIndex = nums.length - 1;
        while(!stack.isEmpty()) result += (lastIndex - stack.pop() + 1);
        return result;
    }
	
	
	public static void main(String[] args) {
		Problem1063 problem = new Problem1063();
		//System.out.println(problem.validSubarrays(new int[] {3, 2, 1}));
		System.out.println(problem.validSubarrays(new int[] {1, 4, 2, 5, 3}));
	}
}
