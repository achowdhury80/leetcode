package com.prep2020.medium;
import java.util.*;
public class Problem1288 {
	/**
	 * O(NlogN) time and O(n) space
	 * @param intervals
	 * @return
	 */
	public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> (x[1] == y[1]) ? (x[0] - y[0]) : (x[1] - y[1]));
        Deque<int[]> stack = new ArrayDeque<>();
        for (int[] intv : intervals) {
        	while(!stack.isEmpty() && stack.peek()[0] >= intv[0]) stack.pop();
        	if (stack.isEmpty() || stack.peek()[1] < intv[1]) stack.push(intv);
        	
        }
        return stack.size();
    }
}
