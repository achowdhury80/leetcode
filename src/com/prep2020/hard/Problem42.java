package com.prep2020.hard;
import java.util.*;
public class Problem42 {
	/**
	 * O(N) time and space
	 * @param height
	 * @return
	 */
	public int trap(int[] height) {
        Deque<Integer> dq = new ArrayDeque<>();
        int result = 0;
        for (int i = 0; i < height.length; i++) {
        	int curHeight = 0;
        	while(!dq.isEmpty() && height[dq.peekLast()] <= height[i]) {
        		int idx = dq.pollLast();
        		result += (i - idx - 1) * (height[idx] - curHeight);
        		curHeight = height[idx];
        	}
        	if (!dq.isEmpty()) result += (i - dq.peekLast() - 1) * (height[i] - curHeight);
        	dq.addLast(i);
        }
        return result;
    }
}
