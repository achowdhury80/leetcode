package com.prep2020.medium;

import java.util.Stack;

public class Problem1130 {
	/**
	 * https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/discuss/339959/One-Pass-O(N)-Time-and-Space
	 * @param arr
	 * @return
	 */
	public int mctFromLeafValues(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		stack.push(Integer.MAX_VALUE);
		int result = 0;
		for (int i : arr) {
			while (i >= stack.peek()) {
				int mid = stack.pop();
				result += mid * Math.min(i, stack.peek());
			}
			stack.push(i);
		}
		while(stack.size() > 2) {
			result += stack.pop() * stack.peek();
		}
		return result;
	}
}
