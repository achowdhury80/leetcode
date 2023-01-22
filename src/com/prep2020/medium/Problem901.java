package com.prep2020.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * O(N)
 * @author aychowdh
 *
 */
public class Problem901 {
	private Deque<int[]> stack;
	private int idx = 0;
	public Problem901() {
		stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
    	idx++;
    	while(!stack.isEmpty() && stack.peek()[1] <= price) stack.pop();
        int count = idx - (stack.isEmpty() ? -1 : stack.peek()[0]);
        stack.push(new int[] {idx++, price});
        return count;
    }
}
