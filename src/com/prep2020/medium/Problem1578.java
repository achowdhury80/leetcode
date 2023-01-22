package com.prep2020.medium;
import java.util.*;
public class Problem1578 {
	/**
	 * O(N)
	 * @param s
	 * @param cost
	 * @return
	 */
	public int minCost(String s, int[] cost) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
        	if (!stack.isEmpty() && s.charAt(stack.peek()) == s.charAt(i)) {
        		if (cost[stack.peek()] < cost[i]) {
        			result += cost[stack.peek()];
        			stack.pop();
        			stack.push(i);
        		} else result += cost[i];
        	} else stack.push(i);
        }
        return result;
    }
}
