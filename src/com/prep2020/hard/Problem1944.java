package com.prep2020.hard;
import java.util.*;
public class Problem1944 {
	/**
	 * O(N)
	 * https://leetcode.com/problems/number-of-visible-people-in-a-queue/discuss/1634511/O(n)-Monotonic-stack-solution-in-Java
	 * @param heights
	 * @return
	 */
	public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i > -1; i--) {
        	while(!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
        		stack.pop();
        		result[i]++;
        	}
        	result[i] += stack.isEmpty() ? 0 : 1;
        	stack.push(i);
        }
        return result;
    }
}
